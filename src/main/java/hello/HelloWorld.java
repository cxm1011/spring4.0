package hello;

public class HelloWorld {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("已赋值。。。");
        this.name = name;
    }

    public HelloWorld(){
        System.out.println("构造方法");
    }

    public void hello() {
        System.out.println("hello:" + name);
    }


}
