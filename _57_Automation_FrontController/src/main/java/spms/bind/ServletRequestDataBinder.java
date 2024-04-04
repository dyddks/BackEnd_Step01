package spms.bind;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

import javax.servlet.ServletRequest;

public class ServletRequestDataBinder {
	// request로부터 Parameter를 추출해서 dataType클래스 정보를 바탕으로 dataName으로 객체를 생성한다.
	public static Object bind(ServletRequest req,Class<?> dataType, String dataName) throws Exception {
		if(isPrimitiveType(dataType)) {
			return createValueObject(dataType, req.getParameter(dataName));
		}
		
		// request에 저장된 모든 parameter의 이름을 얻는다.
		Set<String> paramNames = req.getParameterMap().keySet();
		// 클래스 타입에 따른 객체 생성
		Object dataObject = dataType.getDeclaredConstructor().newInstance();
		// 메소드 정보를 담을 변수
		Method m = null;
		
		// 브라우저에서 보내온 파라미터 개수만큼 반복
		for(String paramName: paramNames) {
			// parameter값에 대응되는 setter를 찾아서 리턴한다.
			// ex) no: setNo, name: setName
			m = findSetter(dataType, paramName);
			if(m != null) {
				// 메소드 정보를 가지고 메소드를 호출
				// dataObject로부터 m에 저장된 setter메서드를 호출해서 값을 저장한다.
				m.invoke(dataObject, createValueObject(m.getParameterTypes()[0], req.getParameter(paramName)));
			}
		}
		
		return dataObject;
	}
	
	// 클래스 타입이 기본타입인지 확인
	private static boolean isPrimitiveType(Class<?> type) {
		if(type.getName().equals("int") || type == Integer.class || 
				type.getName().equals("long") || type == Long.class||
				type.getName().equals("float") || type == Float.class||
				type.getName().equals("double") || type == Double.class||
				type.getName().equals("boolean") || type == Boolean.class||
				type == Date.class || type == String.class) {
			return true;
		}
		return false;
	}
	
	// Primitive 클래스 타입에 따라 객체를 생성하는 메소드
	private static Object createValueObject(Class<?> type, String value) {
		if(type.getName().equals("int") || type == Integer.class) {
			return Integer.valueOf(value);
		}
		if(type.getName().equals("float") || type == Float.class){
			return Float.valueOf(value);
		}
		if(type.getName().equals("double") || type == Double.class){
			return Double.valueOf(value);
		}
		if(type.getName().equals("long") || type == Long.class){
			return Long.valueOf(value);
		}
		if(type.getName().equals("boolean") || type == Boolean.class){
			return Boolean.valueOf(value);
		}
		if(type == Date.class) {
			return java.sql.Date.valueOf(value);
		}
		
		return value; 
	}
	
	private static Method findSetter(Class<?> type, String name) {
		Method[] methods = type.getMethods();
		
		String propName = null;
		for(Method m : methods) {
			// 메소드의 이름이 set으로 시작되지 않는 경우
			if(!m.getName().startsWith("set")) {
				continue;
			}
			
			// set메소드를 찾았으면, set글자를 제외한 나머지 이름을 얻어온다.
			propName = m.getName().substring("set".length());
			if(propName.toLowerCase().equals(name.toLowerCase())) {
				return m;
			}
		}
		return null;
	}
}
