package sun.security.util;

import java.util.ListResourceBundle;

public class Resources_ko extends ListResourceBundle {
  private static final Object[][] contents = { 
      { "invalid.null.input.s.", "널 입력값이 부적합합니다." }, { "actions.can.only.be.read.", "작업은 '읽기' 전용입니다." }, { "permission.name.name.syntax.invalid.", "권한 이름 [{0}] 구문이 부적합함: " }, { "Credential.Class.not.followed.by.a.Principal.Class.and.Name", "인증서 클래스 다음에 주체 클래스와 이름이 없습니다." }, { "Principal.Class.not.followed.by.a.Principal.Name", "주체 클래스 다음에 주체 이름이 없습니다." }, { "Principal.Name.must.be.surrounded.by.quotes", "주체 이름은 따옴표로 묶어야 합니다." }, { "Principal.Name.missing.end.quote", "주체 이름에 닫는 따옴표가 누락되었습니다." }, { "PrivateCredentialPermission.Principal.Class.can.not.be.a.wildcard.value.if.Principal.Name.is.not.a.wildcard.value", "주체 이름이 와일드 카드 문자(*) 값이 아닌 경우 PrivateCredentialPermission 주체 클래스는 와일드 카드 문자(*) 값일 수 없습니다." }, { "CredOwner.Principal.Class.class.Principal.Name.name", "CredOwner:\n\t주체 클래스 = {0}\n\t주체 이름 = {1}" }, { "provided.null.name", "널 이름을 제공했습니다." }, 
      { "provided.null.keyword.map", "널 키워드 맵을 제공했습니다." }, { "provided.null.OID.map", "널 OID 맵을 제공했습니다." }, { "NEWLINE", "\n" }, { "invalid.null.AccessControlContext.provided", "부적합한 널 AccessControlContext가 제공되었습니다." }, { "invalid.null.action.provided", "부적합한 널 작업이 제공되었습니다." }, { "invalid.null.Class.provided", "부적합한 널 클래스가 제공되었습니다." }, { "Subject.", "제목:\n" }, { ".Principal.", "\\주체: " }, { ".Public.Credential.", "\t공용 인증서: " }, { ".Private.Credentials.inaccessible.", "\t전용 인증서에 액세스할 수 없습니다.\n" }, 
      { ".Private.Credential.", "\t전용 인증서: " }, { ".Private.Credential.inaccessible.", "\t전용 인증서에 액세스할 수 없습니다.\n" }, { "Subject.is.read.only", "제목이 읽기 전용입니다." }, { "attempting.to.add.an.object.which.is.not.an.instance.of.java.security.Principal.to.a.Subject.s.Principal.Set", "java.security.Principal의 인스턴스가 아닌 객체를 제목의 주체 집합에 추가하려고 시도하는 중" }, { "attempting.to.add.an.object.which.is.not.an.instance.of.class", "{0}의 인스턴스가 아닌 객체를 추가하려고 시도하는 중" }, { "LoginModuleControlFlag.", "LoginModuleControlFlag: " }, { "Invalid.null.input.name", "부적합한 널 입력값: 이름" }, { "No.LoginModules.configured.for.name", "{0}에 대해 구성된 LoginModules가 없습니다." }, { "invalid.null.Subject.provided", "부적합한 널 제목이 제공되었습니다." }, { "invalid.null.CallbackHandler.provided", "부적합한 널 CallbackHandler가 제공되었습니다." }, 
      { "null.subject.logout.called.before.login", "널 제목 - 로그인 전에 로그아웃이 호출되었습니다." }, { "unable.to.instantiate.LoginModule.module.because.it.does.not.provide.a.no.argument.constructor", "인수가 없는 생성자를 제공하지 않아 LoginModule {0}을(를) 인스턴스화할 수 없습니다." }, { "unable.to.instantiate.LoginModule", "LoginModule을 인스턴스화할 수 없습니다." }, { "unable.to.instantiate.LoginModule.", "LoginModule을 인스턴스화할 수 없음: " }, { "unable.to.find.LoginModule.class.", "LoginModule 클래스를 찾을 수 없음: " }, { "unable.to.access.LoginModule.", "LoginModule에 액세스할 수 없음: " }, { "Login.Failure.all.modules.ignored", "로그인 실패: 모든 모듈이 무시되었습니다." }, { "java.security.policy.error.parsing.policy.message", "java.security.policy: {0}의 구문을 분석하는 중 오류 발생:\n\t{1}" }, { "java.security.policy.error.adding.Permission.perm.message", "java.security.policy: {0} 권한을 추가하는 중 오류 발생:\n\t{1}" }, { "java.security.policy.error.adding.Entry.message", "java.security.policy: 항목을 추가하는 중 오류 발생:\n\t{0}" }, 
      { "alias.name.not.provided.pe.name.", "별칭 이름이 제공되지 않습니다({0})." }, { "unable.to.perform.substitution.on.alias.suffix", "{0} 별칭을 대체할 수 없습니다." }, { "substitution.value.prefix.unsupported", "대체 값 {0}은(는) 지원되지 않습니다." }, { "LPARAM", "(" }, { "RPARAM", ")" }, { "type.can.t.be.null", "유형은 널일 수 없습니다." }, { "keystorePasswordURL.can.not.be.specified.without.also.specifying.keystore", "키 저장소를 지정하지 않고 keystorePasswordURL을 지정할 수 없습니다." }, { "expected.keystore.type", "키 저장소 유형이 필요합니다." }, { "expected.keystore.provider", "키 저장소 제공자가 필요합니다." }, { "multiple.Codebase.expressions", "Codebase 표현식이 여러 개입니다." }, 
      { "multiple.SignedBy.expressions", "SignedBy 표현식이 여러 개입니다." }, { "duplicate.keystore.domain.name", "중복된 키 저장소 도메인 이름: {0}" }, { "duplicate.keystore.name", "중복된 키 저장소 이름: {0}" }, { "SignedBy.has.empty.alias", "SignedBy의 별칭이 비어 있습니다." }, { "can.not.specify.Principal.with.a.wildcard.class.without.a.wildcard.name", "와일드 카드 문자 이름 없이 와일드 카드 문자 클래스를 사용하는 주체를 지정할 수 없습니다." }, { "expected.codeBase.or.SignedBy.or.Principal", "codeBase, SignedBy 또는 주체가 필요합니다." }, { "expected.permission.entry", "권한 항목이 필요합니다." }, { "number.", "숫자 " }, { "expected.expect.read.end.of.file.", "[{0}]이(가) 필요하지만 [파일의 끝]까지 읽었습니다." }, { "expected.read.end.of.file.", "[;]이 필요하지만 [파일의 끝]까지 읽었습니다." }, 
      { "line.number.msg", "{0} 행: {1}" }, { "line.number.expected.expect.found.actual.", "{0} 행: [{1}]이(가) 필요하지만 [{2}]이(가) 발견되었습니다." }, { "null.principalClass.or.principalName", "principalClass 또는 principalName이 널입니다." }, { "PKCS11.Token.providerName.Password.", "PKCS11 토큰 [{0}] 비밀번호: " }, { "unable.to.instantiate.Subject.based.policy", "제목 기반 정책을 인스턴스화할 수 없습니다." } };
  
  public Object[][] getContents() { return contents; }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\sun\securit\\util\Resources_ko.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */