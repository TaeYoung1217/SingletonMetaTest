package mission.SingletonMetaTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SingletonContext {

    private static SingletonConfig config;
    private static Map<String, Method> singletonMap = new HashMap<>();
    private static Map<String, Object> singletonObjectMap = new HashMap<>();

    public static void setConfig(SingletonConfig config) {
        SingletonContext.config = config;
    }

    static synchronized Object getSingleton(String name) {
        //TODO: 아래 구문 삭제 후, Map을 이용한 Singleton 생성 로직 구현 필요합니다.
        Object object = singletonObjectMap.get(name);
        if (object == null) { //singletonObjectMap에 키에 해당하는 값이 없으면
            try {
                object = singletonMap.get(name).invoke(config);
                //singletonMap에서 키에 해당하는 메소드 가져와서 config객체에 있는 메소드 실행(invoke)
                singletonObjectMap.put(name, object); //singletonObjectMap에 put
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return object; //있으면 있는 object 그대로 return, 없으면 위에 if문에서 생성 후 return
    }

    public static void executeMethodsBySingletonAnnotation(Object object) {
        // TODO - 1: Object 가 들어 오면 해당 클래스의 Method를 돌면서, @Singleton annotation을 발견합니다.
        // TODO - 2: 해당 Annotation의 name 과 method를 적당한 Map에 저장합니다.

        Class clazz = object.getClass(); //object를 받아오기 위한 Class 클래스 생성 후 getClass로 클래스 확인
        Method[] methods = clazz.getDeclaredMethods(); //모든 메소드 가져오기

        for (Method method : methods) { //모든 메소드를 반복문 돌며
            Annotation[] annotations = method.getDeclaredAnnotations(); //메소드에 붙은 어노테이션 가져와서
            for (Annotation annotation : annotations) { //모든 어노테이션 돌며
                if (annotation instanceof Singleton) { //어노테이션이 Singleton 어노테이션이면
                    Singleton singleton = (Singleton) annotation; //Singleton 어노테이션 객체 생성
                    singletonMap.put(singleton.name(), method); //singleton 객체의 이름과 메소드 저장
                }
            }
        }

    }

}