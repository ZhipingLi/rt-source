package com.sun.xml.internal.ws.transport.http.server;

import com.oracle.webservices.internal.api.message.BasePropertySet;
import com.oracle.webservices.internal.api.message.PropertySet.Property;
import com.sun.istack.internal.NotNull;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.server.PortAddressResolver;
import com.sun.xml.internal.ws.api.server.WSEndpoint;
import com.sun.xml.internal.ws.api.server.WebServiceContextDelegate;
import com.sun.xml.internal.ws.resources.WsservletMessages;
import com.sun.xml.internal.ws.transport.http.HttpAdapter;
import com.sun.xml.internal.ws.transport.http.WSHTTPConnection;
import com.sun.xml.internal.ws.util.ReadAllStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.ws.WebServiceException;

final class ServerConnectionImpl extends WSHTTPConnection implements WebServiceContextDelegate {
  private final HttpExchange httpExchange;
  
  private int status;
  
  private final HttpAdapter adapter;
  
  private LWHSInputStream in;
  
  private OutputStream out;
  
  private static final BasePropertySet.PropertyMap model = parse(ServerConnectionImpl.class);
  
  public ServerConnectionImpl(@NotNull HttpAdapter paramHttpAdapter, @NotNull HttpExchange paramHttpExchange) {
    this.adapter = paramHttpAdapter;
    this.httpExchange = paramHttpExchange;
  }
  
  @Property({"javax.xml.ws.http.request.headers", "com.sun.xml.internal.ws.api.message.packet.inbound.transport.headers"})
  @NotNull
  public Map<String, List<String>> getRequestHeaders() { return this.httpExchange.getRequestHeaders(); }
  
  public String getRequestHeader(String paramString) { return this.httpExchange.getRequestHeaders().getFirst(paramString); }
  
  public void setResponseHeaders(Map<String, List<String>> paramMap) {
    Headers headers = this.httpExchange.getResponseHeaders();
    headers.clear();
    for (Map.Entry entry : paramMap.entrySet()) {
      String str = (String)entry.getKey();
      List list = (List)entry.getValue();
      if (!"Content-Length".equalsIgnoreCase(str) && !"Content-Type".equalsIgnoreCase(str))
        headers.put(str, new ArrayList(list)); 
    } 
  }
  
  public void setResponseHeader(String paramString, List<String> paramList) { this.httpExchange.getResponseHeaders().put(paramString, paramList); }
  
  public Set<String> getRequestHeaderNames() { return this.httpExchange.getRequestHeaders().keySet(); }
  
  public List<String> getRequestHeaderValues(String paramString) { return this.httpExchange.getRequestHeaders().get(paramString); }
  
  @Property({"javax.xml.ws.http.response.headers", "com.sun.xml.internal.ws.api.message.packet.outbound.transport.headers"})
  public Map<String, List<String>> getResponseHeaders() { return this.httpExchange.getResponseHeaders(); }
  
  public void setContentTypeResponseHeader(@NotNull String paramString) { this.httpExchange.getResponseHeaders().set("Content-Type", paramString); }
  
  public void setStatus(int paramInt) { this.status = paramInt; }
  
  @Property({"javax.xml.ws.http.response.code"})
  public int getStatus() { return this.status; }
  
  @NotNull
  public InputStream getInput() {
    if (this.in == null)
      this.in = new LWHSInputStream(this.httpExchange.getRequestBody()); 
    return this.in;
  }
  
  @NotNull
  public OutputStream getOutput() throws IOException {
    if (this.out == null) {
      String str = this.httpExchange.getResponseHeaders().getFirst("Content-Length");
      int i = (str != null) ? Integer.parseInt(str) : 0;
      this.httpExchange.sendResponseHeaders(getStatus(), i);
      this.out = new FilterOutputStream(this.httpExchange.getResponseBody()) {
          boolean closed;
          
          public void close() throws IOException {
            if (!this.closed) {
              this.closed = true;
              ServerConnectionImpl.this.in.readAll();
              try {
                super.close();
              } catch (IOException iOException) {}
            } 
          }
          
          public void write(byte[] param1ArrayOfByte, int param1Int1, int param1Int2) throws IOException { this.out.write(param1ArrayOfByte, param1Int1, param1Int2); }
        };
    } 
    return this.out;
  }
  
  @NotNull
  public WebServiceContextDelegate getWebServiceContextDelegate() { return this; }
  
  public Principal getUserPrincipal(Packet paramPacket) { return this.httpExchange.getPrincipal(); }
  
  public boolean isUserInRole(Packet paramPacket, String paramString) { return false; }
  
  @NotNull
  public String getEPRAddress(Packet paramPacket, WSEndpoint paramWSEndpoint) {
    PortAddressResolver portAddressResolver = this.adapter.owner.createPortAddressResolver(getBaseAddress(), paramWSEndpoint.getImplementationClass());
    String str = portAddressResolver.getAddressFor(paramWSEndpoint.getServiceName(), paramWSEndpoint.getPortName().getLocalPart());
    if (str == null)
      throw new WebServiceException(WsservletMessages.SERVLET_NO_ADDRESS_AVAILABLE(paramWSEndpoint.getPortName())); 
    return str;
  }
  
  public String getWSDLAddress(@NotNull Packet paramPacket, @NotNull WSEndpoint paramWSEndpoint) {
    String str = getEPRAddress(paramPacket, paramWSEndpoint);
    return (this.adapter.getEndpoint().getPort() != null) ? (str + "?wsdl") : null;
  }
  
  public boolean isSecure() { return this.httpExchange instanceof com.sun.net.httpserver.HttpsExchange; }
  
  @Property({"javax.xml.ws.http.request.method"})
  @NotNull
  public String getRequestMethod() { return this.httpExchange.getRequestMethod(); }
  
  @Property({"javax.xml.ws.http.request.querystring"})
  public String getQueryString() {
    URI uRI = this.httpExchange.getRequestURI();
    String str = uRI.getQuery();
    return (str != null) ? str : null;
  }
  
  @Property({"javax.xml.ws.http.request.pathinfo"})
  public String getPathInfo() {
    URI uRI = this.httpExchange.getRequestURI();
    String str1 = uRI.getPath();
    String str2 = this.httpExchange.getHttpContext().getPath();
    return (str1.length() > str2.length()) ? str1.substring(str2.length()) : null;
  }
  
  @Property({"com.sun.xml.internal.ws.http.exchange"})
  public HttpExchange getExchange() { return this.httpExchange; }
  
  @NotNull
  public String getBaseAddress() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((this.httpExchange instanceof com.sun.net.httpserver.HttpsExchange) ? "https" : "http");
    stringBuilder.append("://");
    String str = this.httpExchange.getRequestHeaders().getFirst("Host");
    if (str != null) {
      stringBuilder.append(str);
    } else {
      stringBuilder.append(this.httpExchange.getLocalAddress().getHostName());
      stringBuilder.append(":");
      stringBuilder.append(this.httpExchange.getLocalAddress().getPort());
    } 
    return stringBuilder.toString();
  }
  
  public String getProtocol() { return this.httpExchange.getProtocol(); }
  
  public void setContentLengthResponseHeader(int paramInt) { this.httpExchange.getResponseHeaders().set("Content-Length", "" + paramInt); }
  
  public String getRequestURI() { return this.httpExchange.getRequestURI().toString(); }
  
  public String getRequestScheme() { return (this.httpExchange instanceof com.sun.net.httpserver.HttpsExchange) ? "https" : "http"; }
  
  public String getServerName() { return this.httpExchange.getLocalAddress().getHostName(); }
  
  public int getServerPort() { return this.httpExchange.getLocalAddress().getPort(); }
  
  protected BasePropertySet.PropertyMap getPropertyMap() { return model; }
  
  private static class LWHSInputStream extends FilterInputStream {
    boolean closed;
    
    boolean readAll;
    
    LWHSInputStream(InputStream param1InputStream) { super(param1InputStream); }
    
    void readAll() throws IOException {
      if (!this.closed && !this.readAll) {
        ReadAllStream readAllStream = new ReadAllStream();
        readAllStream.readAll(this.in, 4000000L);
        this.in.close();
        this.in = readAllStream;
        this.readAll = true;
      } 
    }
    
    public void close() throws IOException {
      if (!this.closed) {
        readAll();
        super.close();
        this.closed = true;
      } 
    }
  }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\com\sun\xml\internal\ws\transport\http\server\ServerConnectionImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */