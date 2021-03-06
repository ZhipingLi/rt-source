package sun.nio.cs;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

class UTF_8 extends Unicode {
  public UTF_8() { super("UTF-8", StandardCharsets.aliases_UTF_8); }
  
  public String historicalName() { return "UTF8"; }
  
  public CharsetDecoder newDecoder() { return new Decoder(this, null); }
  
  public CharsetEncoder newEncoder() { return new Encoder(this, null); }
  
  private static final void updatePositions(Buffer paramBuffer1, int paramInt1, Buffer paramBuffer2, int paramInt2) {
    paramBuffer1.position(paramInt1 - paramBuffer1.arrayOffset());
    paramBuffer2.position(paramInt2 - paramBuffer2.arrayOffset());
  }
  
  private static class Decoder extends CharsetDecoder implements ArrayDecoder {
    private Decoder(Charset param1Charset) { super(param1Charset, 1.0F, 1.0F); }
    
    private static boolean isNotContinuation(int param1Int) { return ((param1Int & 0xC0) != 128); }
    
    private static boolean isMalformed3(int param1Int1, int param1Int2, int param1Int3) { return ((param1Int1 == -32 && (param1Int2 & 0xE0) == 128) || (param1Int2 & 0xC0) != 128 || (param1Int3 & 0xC0) != 128); }
    
    private static boolean isMalformed3_2(int param1Int1, int param1Int2) { return ((param1Int1 == -32 && (param1Int2 & 0xE0) == 128) || (param1Int2 & 0xC0) != 128); }
    
    private static boolean isMalformed4(int param1Int1, int param1Int2, int param1Int3) { return ((param1Int1 & 0xC0) != 128 || (param1Int2 & 0xC0) != 128 || (param1Int3 & 0xC0) != 128); }
    
    private static boolean isMalformed4_2(int param1Int1, int param1Int2) { return ((param1Int1 == 240 && (param1Int2 < 144 || param1Int2 > 191)) || (param1Int1 == 244 && (param1Int2 & 0xF0) != 128) || (param1Int2 & 0xC0) != 128); }
    
    private static boolean isMalformed4_3(int param1Int) { return ((param1Int & 0xC0) != 128); }
    
    private static CoderResult lookupN(ByteBuffer param1ByteBuffer, int param1Int) {
      for (byte b = 1; b < param1Int; b++) {
        if (isNotContinuation(param1ByteBuffer.get()))
          return CoderResult.malformedForLength(b); 
      } 
      return CoderResult.malformedForLength(param1Int);
    }
    
    private static CoderResult malformedN(ByteBuffer param1ByteBuffer, int param1Int) {
      byte b2;
      byte b1;
      switch (param1Int) {
        case 1:
        case 2:
          return CoderResult.malformedForLength(1);
        case 3:
          b1 = param1ByteBuffer.get();
          b2 = param1ByteBuffer.get();
          return CoderResult.malformedForLength(((b1 == -32 && (b2 & 0xE0) == 128) || isNotContinuation(b2)) ? 1 : 2);
        case 4:
          b1 = param1ByteBuffer.get() & 0xFF;
          b2 = param1ByteBuffer.get() & 0xFF;
          return (b1 > 244 || (b1 == 240 && (b2 < 144 || b2 > 191)) || (b1 == 244 && (b2 & 0xF0) != 128) || isNotContinuation(b2)) ? CoderResult.malformedForLength(1) : (isNotContinuation(param1ByteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3));
      } 
      assert false;
      return null;
    }
    
    private static CoderResult malformed(ByteBuffer param1ByteBuffer, int param1Int1, CharBuffer param1CharBuffer, int param1Int2, int param1Int3) {
      param1ByteBuffer.position(param1Int1 - param1ByteBuffer.arrayOffset());
      CoderResult coderResult = malformedN(param1ByteBuffer, param1Int3);
      UTF_8.updatePositions(param1ByteBuffer, param1Int1, param1CharBuffer, param1Int2);
      return coderResult;
    }
    
    private static CoderResult malformed(ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2) {
      param1ByteBuffer.position(param1Int1);
      CoderResult coderResult = malformedN(param1ByteBuffer, param1Int2);
      param1ByteBuffer.position(param1Int1);
      return coderResult;
    }
    
    private static CoderResult malformedForLength(ByteBuffer param1ByteBuffer, int param1Int1, CharBuffer param1CharBuffer, int param1Int2, int param1Int3) {
      UTF_8.updatePositions(param1ByteBuffer, param1Int1, param1CharBuffer, param1Int2);
      return CoderResult.malformedForLength(param1Int3);
    }
    
    private static CoderResult malformedForLength(ByteBuffer param1ByteBuffer, int param1Int1, int param1Int2) {
      param1ByteBuffer.position(param1Int1);
      return CoderResult.malformedForLength(param1Int2);
    }
    
    private static CoderResult xflow(Buffer param1Buffer1, int param1Int1, int param1Int2, Buffer param1Buffer2, int param1Int3, int param1Int4) {
      UTF_8.updatePositions(param1Buffer1, param1Int1, param1Buffer2, param1Int3);
      return (param1Int4 == 0 || param1Int2 - param1Int1 < param1Int4) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }
    
    private static CoderResult xflow(Buffer param1Buffer, int param1Int1, int param1Int2) {
      param1Buffer.position(param1Int1);
      return (param1Int2 == 0 || param1Buffer.remaining() < param1Int2) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }
    
    private CoderResult decodeArrayLoop(ByteBuffer param1ByteBuffer, CharBuffer param1CharBuffer) {
      byte[] arrayOfByte = param1ByteBuffer.array();
      int i = param1ByteBuffer.arrayOffset() + param1ByteBuffer.position();
      int j = param1ByteBuffer.arrayOffset() + param1ByteBuffer.limit();
      char[] arrayOfChar = param1CharBuffer.array();
      int k = param1CharBuffer.arrayOffset() + param1CharBuffer.position();
      int m = param1CharBuffer.arrayOffset() + param1CharBuffer.limit();
      int n = k + Math.min(j - i, m - k);
      while (k < n && arrayOfByte[i] >= 0)
        arrayOfChar[k++] = (char)arrayOfByte[i++]; 
      while (i < j) {
        byte b = arrayOfByte[i];
        if (b >= 0) {
          if (k >= m)
            return xflow(param1ByteBuffer, i, j, param1CharBuffer, k, 1); 
          arrayOfChar[k++] = (char)b;
          i++;
          continue;
        } 
        if (b >> 5 == -2 && (b & 0x1E) != 0) {
          if (j - i < 2 || k >= m)
            return xflow(param1ByteBuffer, i, j, param1CharBuffer, k, 2); 
          byte b1 = arrayOfByte[i + 1];
          if (isNotContinuation(b1))
            return malformedForLength(param1ByteBuffer, i, param1CharBuffer, k, 1); 
          arrayOfChar[k++] = (char)(b << 6 ^ b1 ^ 0xF80);
          i += 2;
          continue;
        } 
        if (b >> 4 == -2) {
          int i1 = j - i;
          if (i1 < 3 || k >= m)
            return (i1 > 1 && isMalformed3_2(b, arrayOfByte[i + 1])) ? malformedForLength(param1ByteBuffer, i, param1CharBuffer, k, 1) : xflow(param1ByteBuffer, i, j, param1CharBuffer, k, 3); 
          byte b1 = arrayOfByte[i + 1];
          byte b2 = arrayOfByte[i + 2];
          if (isMalformed3(b, b1, b2))
            return malformed(param1ByteBuffer, i, param1CharBuffer, k, 3); 
          char c = (char)(b << 12 ^ b1 << 6 ^ b2 ^ 0xFFFE1F80);
          if (Character.isSurrogate(c))
            return malformedForLength(param1ByteBuffer, i, param1CharBuffer, k, 3); 
          arrayOfChar[k++] = c;
          i += 3;
          continue;
        } 
        if (b >> 3 == -2) {
          int i1 = j - i;
          if (i1 < 4 || m - k < 2) {
            b &= 0xFF;
            return (b > 244 || (i1 > 1 && isMalformed4_2(b, arrayOfByte[i + 1] & 0xFF))) ? malformedForLength(param1ByteBuffer, i, param1CharBuffer, k, 1) : ((i1 > 2 && isMalformed4_3(arrayOfByte[i + 2])) ? malformedForLength(param1ByteBuffer, i, param1CharBuffer, k, 2) : xflow(param1ByteBuffer, i, j, param1CharBuffer, k, 4));
          } 
          byte b1 = arrayOfByte[i + 1];
          byte b2 = arrayOfByte[i + 2];
          byte b3 = arrayOfByte[i + 3];
          byte b4 = b << 18 ^ b1 << 12 ^ b2 << 6 ^ b3 ^ 0x381F80;
          if (isMalformed4(b1, b2, b3) || !Character.isSupplementaryCodePoint(b4))
            return malformed(param1ByteBuffer, i, param1CharBuffer, k, 4); 
          arrayOfChar[k++] = Character.highSurrogate(b4);
          arrayOfChar[k++] = Character.lowSurrogate(b4);
          i += 4;
          continue;
        } 
        return malformed(param1ByteBuffer, i, param1CharBuffer, k, 1);
      } 
      return xflow(param1ByteBuffer, i, j, param1CharBuffer, k, 0);
    }
    
    private CoderResult decodeBufferLoop(ByteBuffer param1ByteBuffer, CharBuffer param1CharBuffer) {
      int i = param1ByteBuffer.position();
      int j = param1ByteBuffer.limit();
      while (i < j) {
        byte b = param1ByteBuffer.get();
        if (b >= 0) {
          if (param1CharBuffer.remaining() < 1)
            return xflow(param1ByteBuffer, i, 1); 
          param1CharBuffer.put((char)b);
          i++;
          continue;
        } 
        if (b >> 5 == -2 && (b & 0x1E) != 0) {
          if (j - i < 2 || param1CharBuffer.remaining() < 1)
            return xflow(param1ByteBuffer, i, 2); 
          byte b1 = param1ByteBuffer.get();
          if (isNotContinuation(b1))
            return malformedForLength(param1ByteBuffer, i, 1); 
          param1CharBuffer.put((char)(b << 6 ^ b1 ^ 0xF80));
          i += 2;
          continue;
        } 
        if (b >> 4 == -2) {
          int k = j - i;
          if (k < 3 || param1CharBuffer.remaining() < 1)
            return (k > 1 && isMalformed3_2(b, param1ByteBuffer.get())) ? malformedForLength(param1ByteBuffer, i, 1) : xflow(param1ByteBuffer, i, 3); 
          byte b1 = param1ByteBuffer.get();
          byte b2 = param1ByteBuffer.get();
          if (isMalformed3(b, b1, b2))
            return malformed(param1ByteBuffer, i, 3); 
          char c = (char)(b << 12 ^ b1 << 6 ^ b2 ^ 0xFFFE1F80);
          if (Character.isSurrogate(c))
            return malformedForLength(param1ByteBuffer, i, 3); 
          param1CharBuffer.put(c);
          i += 3;
          continue;
        } 
        if (b >> 3 == -2) {
          int k = j - i;
          if (k < 4 || param1CharBuffer.remaining() < 2) {
            b &= 0xFF;
            return (b > 244 || (k > 1 && isMalformed4_2(b, param1ByteBuffer.get() & 0xFF))) ? malformedForLength(param1ByteBuffer, i, 1) : ((k > 2 && isMalformed4_3(param1ByteBuffer.get())) ? malformedForLength(param1ByteBuffer, i, 2) : xflow(param1ByteBuffer, i, 4));
          } 
          byte b1 = param1ByteBuffer.get();
          byte b2 = param1ByteBuffer.get();
          byte b3 = param1ByteBuffer.get();
          byte b4 = b << 18 ^ b1 << 12 ^ b2 << 6 ^ b3 ^ 0x381F80;
          if (isMalformed4(b1, b2, b3) || !Character.isSupplementaryCodePoint(b4))
            return malformed(param1ByteBuffer, i, 4); 
          param1CharBuffer.put(Character.highSurrogate(b4));
          param1CharBuffer.put(Character.lowSurrogate(b4));
          i += 4;
          continue;
        } 
        return malformed(param1ByteBuffer, i, 1);
      } 
      return xflow(param1ByteBuffer, i, 0);
    }
    
    protected CoderResult decodeLoop(ByteBuffer param1ByteBuffer, CharBuffer param1CharBuffer) { return (param1ByteBuffer.hasArray() && param1CharBuffer.hasArray()) ? decodeArrayLoop(param1ByteBuffer, param1CharBuffer) : decodeBufferLoop(param1ByteBuffer, param1CharBuffer); }
    
    private static ByteBuffer getByteBuffer(ByteBuffer param1ByteBuffer, byte[] param1ArrayOfByte, int param1Int) {
      if (param1ByteBuffer == null)
        param1ByteBuffer = ByteBuffer.wrap(param1ArrayOfByte); 
      param1ByteBuffer.position(param1Int);
      return param1ByteBuffer;
    }
    
    public int decode(byte[] param1ArrayOfByte, int param1Int1, int param1Int2, char[] param1ArrayOfChar) {
      int i = param1Int1 + param1Int2;
      byte b = 0;
      int j = Math.min(param1Int2, param1ArrayOfChar.length);
      ByteBuffer byteBuffer = null;
      while (b < j && param1ArrayOfByte[param1Int1] >= 0)
        param1ArrayOfChar[b++] = (char)param1ArrayOfByte[param1Int1++]; 
      while (param1Int1 < i) {
        byte b1 = param1ArrayOfByte[param1Int1++];
        if (b1 >= 0) {
          param1ArrayOfChar[b++] = (char)b1;
          continue;
        } 
        if (b1 >> 5 == -2 && (b1 & 0x1E) != 0) {
          if (param1Int1 < i) {
            byte b2 = param1ArrayOfByte[param1Int1++];
            if (isNotContinuation(b2)) {
              if (malformedInputAction() != CodingErrorAction.REPLACE)
                return -1; 
              param1ArrayOfChar[b++] = replacement().charAt(0);
              param1Int1--;
              continue;
            } 
            param1ArrayOfChar[b++] = (char)(b1 << 6 ^ b2 ^ 0xF80);
            continue;
          } 
          if (malformedInputAction() != CodingErrorAction.REPLACE)
            return -1; 
          param1ArrayOfChar[b++] = replacement().charAt(0);
          return b;
        } 
        if (b1 >> 4 == -2) {
          if (param1Int1 + 1 < i) {
            byte b2 = param1ArrayOfByte[param1Int1++];
            byte b3 = param1ArrayOfByte[param1Int1++];
            if (isMalformed3(b1, b2, b3)) {
              if (malformedInputAction() != CodingErrorAction.REPLACE)
                return -1; 
              param1ArrayOfChar[b++] = replacement().charAt(0);
              param1Int1 -= 3;
              byteBuffer = getByteBuffer(byteBuffer, param1ArrayOfByte, param1Int1);
              param1Int1 += malformedN(byteBuffer, 3).length();
              continue;
            } 
            char c = (char)(b1 << 12 ^ b2 << 6 ^ b3 ^ 0xFFFE1F80);
            if (Character.isSurrogate(c)) {
              if (malformedInputAction() != CodingErrorAction.REPLACE)
                return -1; 
              param1ArrayOfChar[b++] = replacement().charAt(0);
              continue;
            } 
            param1ArrayOfChar[b++] = c;
            continue;
          } 
          if (malformedInputAction() != CodingErrorAction.REPLACE)
            return -1; 
          if (param1Int1 < i && isMalformed3_2(b1, param1ArrayOfByte[param1Int1])) {
            param1ArrayOfChar[b++] = replacement().charAt(0);
            continue;
          } 
          param1ArrayOfChar[b++] = replacement().charAt(0);
          return b;
        } 
        if (b1 >> 3 == -2) {
          if (param1Int1 + 2 < i) {
            byte b2 = param1ArrayOfByte[param1Int1++];
            byte b3 = param1ArrayOfByte[param1Int1++];
            byte b4 = param1ArrayOfByte[param1Int1++];
            byte b5 = b1 << 18 ^ b2 << 12 ^ b3 << 6 ^ b4 ^ 0x381F80;
            if (isMalformed4(b2, b3, b4) || !Character.isSupplementaryCodePoint(b5)) {
              if (malformedInputAction() != CodingErrorAction.REPLACE)
                return -1; 
              param1ArrayOfChar[b++] = replacement().charAt(0);
              param1Int1 -= 4;
              byteBuffer = getByteBuffer(byteBuffer, param1ArrayOfByte, param1Int1);
              param1Int1 += malformedN(byteBuffer, 4).length();
              continue;
            } 
            param1ArrayOfChar[b++] = Character.highSurrogate(b5);
            param1ArrayOfChar[b++] = Character.lowSurrogate(b5);
            continue;
          } 
          if (malformedInputAction() != CodingErrorAction.REPLACE)
            return -1; 
          b1 &= 0xFF;
          if (b1 > 244 || (param1Int1 < i && isMalformed4_2(b1, param1ArrayOfByte[param1Int1] & 0xFF))) {
            param1ArrayOfChar[b++] = replacement().charAt(0);
            continue;
          } 
          if (++param1Int1 < i && isMalformed4_3(param1ArrayOfByte[param1Int1])) {
            param1ArrayOfChar[b++] = replacement().charAt(0);
            continue;
          } 
          param1ArrayOfChar[b++] = replacement().charAt(0);
          return b;
        } 
        if (malformedInputAction() != CodingErrorAction.REPLACE)
          return -1; 
        param1ArrayOfChar[b++] = replacement().charAt(0);
      } 
      return b;
    }
  }
  
  private static final class Encoder extends CharsetEncoder implements ArrayEncoder {
    private Surrogate.Parser sgp;
    
    private byte repl = 63;
    
    private Encoder(Charset param1Charset) { super(param1Charset, 1.1F, 3.0F); }
    
    public boolean canEncode(char param1Char) { return !Character.isSurrogate(param1Char); }
    
    public boolean isLegalReplacement(byte[] param1ArrayOfByte) { return ((param1ArrayOfByte.length == 1 && param1ArrayOfByte[0] >= 0) || super.isLegalReplacement(param1ArrayOfByte)); }
    
    private static CoderResult overflow(CharBuffer param1CharBuffer, int param1Int1, ByteBuffer param1ByteBuffer, int param1Int2) {
      UTF_8.updatePositions(param1CharBuffer, param1Int1, param1ByteBuffer, param1Int2);
      return CoderResult.OVERFLOW;
    }
    
    private static CoderResult overflow(CharBuffer param1CharBuffer, int param1Int) {
      param1CharBuffer.position(param1Int);
      return CoderResult.OVERFLOW;
    }
    
    private CoderResult encodeArrayLoop(CharBuffer param1CharBuffer, ByteBuffer param1ByteBuffer) {
      char[] arrayOfChar = param1CharBuffer.array();
      int i = param1CharBuffer.arrayOffset() + param1CharBuffer.position();
      int j = param1CharBuffer.arrayOffset() + param1CharBuffer.limit();
      byte[] arrayOfByte = param1ByteBuffer.array();
      int k = param1ByteBuffer.arrayOffset() + param1ByteBuffer.position();
      int m = param1ByteBuffer.arrayOffset() + param1ByteBuffer.limit();
      int n = k + Math.min(j - i, m - k);
      while (k < n && arrayOfChar[i] < '??')
        arrayOfByte[k++] = (byte)arrayOfChar[i++]; 
      while (i < j) {
        char c = arrayOfChar[i];
        if (c < '??') {
          if (k >= m)
            return overflow(param1CharBuffer, i, param1ByteBuffer, k); 
          arrayOfByte[k++] = (byte)c;
        } else if (c < '???') {
          if (m - k < 2)
            return overflow(param1CharBuffer, i, param1ByteBuffer, k); 
          arrayOfByte[k++] = (byte)(0xC0 | c >> '\006');
          arrayOfByte[k++] = (byte)(0x80 | c & 0x3F);
        } else if (Character.isSurrogate(c)) {
          if (this.sgp == null)
            this.sgp = new Surrogate.Parser(); 
          int i1 = this.sgp.parse(c, arrayOfChar, i, j);
          if (i1 < 0) {
            UTF_8.updatePositions(param1CharBuffer, i, param1ByteBuffer, k);
            return this.sgp.error();
          } 
          if (m - k < 4)
            return overflow(param1CharBuffer, i, param1ByteBuffer, k); 
          arrayOfByte[k++] = (byte)(0xF0 | i1 >> 18);
          arrayOfByte[k++] = (byte)(0x80 | i1 >> 12 & 0x3F);
          arrayOfByte[k++] = (byte)(0x80 | i1 >> 6 & 0x3F);
          arrayOfByte[k++] = (byte)(0x80 | i1 & 0x3F);
          i++;
        } else {
          if (m - k < 3)
            return overflow(param1CharBuffer, i, param1ByteBuffer, k); 
          arrayOfByte[k++] = (byte)(0xE0 | c >> '\f');
          arrayOfByte[k++] = (byte)(0x80 | c >> '\006' & 0x3F);
          arrayOfByte[k++] = (byte)(0x80 | c & 0x3F);
        } 
        i++;
      } 
      UTF_8.updatePositions(param1CharBuffer, i, param1ByteBuffer, k);
      return CoderResult.UNDERFLOW;
    }
    
    private CoderResult encodeBufferLoop(CharBuffer param1CharBuffer, ByteBuffer param1ByteBuffer) {
      int i;
      for (i = param1CharBuffer.position(); param1CharBuffer.hasRemaining(); i++) {
        char c = param1CharBuffer.get();
        if (c < '??') {
          if (!param1ByteBuffer.hasRemaining())
            return overflow(param1CharBuffer, i); 
          param1ByteBuffer.put((byte)c);
        } else if (c < '???') {
          if (param1ByteBuffer.remaining() < 2)
            return overflow(param1CharBuffer, i); 
          param1ByteBuffer.put((byte)(0xC0 | c >> '\006'));
          param1ByteBuffer.put((byte)(0x80 | c & 0x3F));
        } else if (Character.isSurrogate(c)) {
          if (this.sgp == null)
            this.sgp = new Surrogate.Parser(); 
          int j = this.sgp.parse(c, param1CharBuffer);
          if (j < 0) {
            param1CharBuffer.position(i);
            return this.sgp.error();
          } 
          if (param1ByteBuffer.remaining() < 4)
            return overflow(param1CharBuffer, i); 
          param1ByteBuffer.put((byte)(0xF0 | j >> 18));
          param1ByteBuffer.put((byte)(0x80 | j >> 12 & 0x3F));
          param1ByteBuffer.put((byte)(0x80 | j >> 6 & 0x3F));
          param1ByteBuffer.put((byte)(0x80 | j & 0x3F));
          i++;
        } else {
          if (param1ByteBuffer.remaining() < 3)
            return overflow(param1CharBuffer, i); 
          param1ByteBuffer.put((byte)(0xE0 | c >> '\f'));
          param1ByteBuffer.put((byte)(0x80 | c >> '\006' & 0x3F));
          param1ByteBuffer.put((byte)(0x80 | c & 0x3F));
        } 
      } 
      param1CharBuffer.position(i);
      return CoderResult.UNDERFLOW;
    }
    
    protected final CoderResult encodeLoop(CharBuffer param1CharBuffer, ByteBuffer param1ByteBuffer) { return (param1CharBuffer.hasArray() && param1ByteBuffer.hasArray()) ? encodeArrayLoop(param1CharBuffer, param1ByteBuffer) : encodeBufferLoop(param1CharBuffer, param1ByteBuffer); }
    
    protected void implReplaceWith(byte[] param1ArrayOfByte) { this.repl = param1ArrayOfByte[0]; }
    
    public int encode(char[] param1ArrayOfChar, int param1Int1, int param1Int2, byte[] param1ArrayOfByte) {
      int i = param1Int1 + param1Int2;
      int j = 0;
      int k = j + Math.min(param1Int2, param1ArrayOfByte.length);
      while (j < k && param1ArrayOfChar[param1Int1] < '??')
        param1ArrayOfByte[j++] = (byte)param1ArrayOfChar[param1Int1++]; 
      while (param1Int1 < i) {
        char c = param1ArrayOfChar[param1Int1++];
        if (c < '??') {
          param1ArrayOfByte[j++] = (byte)c;
          continue;
        } 
        if (c < '???') {
          param1ArrayOfByte[j++] = (byte)(0xC0 | c >> '\006');
          param1ArrayOfByte[j++] = (byte)(0x80 | c & 0x3F);
          continue;
        } 
        if (Character.isSurrogate(c)) {
          if (this.sgp == null)
            this.sgp = new Surrogate.Parser(); 
          int m = this.sgp.parse(c, param1ArrayOfChar, param1Int1 - 1, i);
          if (m < 0) {
            if (malformedInputAction() != CodingErrorAction.REPLACE)
              return -1; 
            param1ArrayOfByte[j++] = this.repl;
            continue;
          } 
          param1ArrayOfByte[j++] = (byte)(0xF0 | m >> 18);
          param1ArrayOfByte[j++] = (byte)(0x80 | m >> 12 & 0x3F);
          param1ArrayOfByte[j++] = (byte)(0x80 | m >> 6 & 0x3F);
          param1ArrayOfByte[j++] = (byte)(0x80 | m & 0x3F);
          param1Int1++;
          continue;
        } 
        param1ArrayOfByte[j++] = (byte)(0xE0 | c >> '\f');
        param1ArrayOfByte[j++] = (byte)(0x80 | c >> '\006' & 0x3F);
        param1ArrayOfByte[j++] = (byte)(0x80 | c & 0x3F);
      } 
      return j;
    }
  }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\sun\nio\cs\UTF_8.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */