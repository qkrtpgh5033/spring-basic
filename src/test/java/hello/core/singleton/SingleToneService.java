package hello.core.singleton;

public class SingleToneService {

    private static SingleToneService singleToneService = new SingleToneService();

    private SingleToneService(){

    }

    public static SingleToneService getInstance(){
        return singleToneService;
    }

    public void logic() {
        System.out.println("싱글톤 객체 호출 ");
    }

}
