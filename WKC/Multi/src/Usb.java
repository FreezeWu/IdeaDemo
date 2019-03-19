public interface Usb {

    default void startEquip(){
        System.out.println("设备已接入Usb");
    }



    default void closeEquip(){
        System.out.println("设备已拔出Usb");
    }
}

class Labtop {
    String name;



    public Labtop(String name) {
        this.name = name;
    }

    public void start(){
        System.out.println("开机");
    }

    public void close(){
        System.out.println("关机");
    }

    public void useUsbEquip(Usb usb){
        usb.startEquip();

        if(usb instanceof Mouse){
            Mouse mouse = (Mouse) usb;
            System.out.println("连入设备名称：" + mouse.getName());
            mouse.click();
        }

        if(usb instanceof Keyboard){
            Keyboard keyboard = (Keyboard) usb;
            System.out.println("连入设备名称：" + keyboard.getName());
            keyboard.press();
        }


    }
    public void closeUsbEquip(Usb usb){
        usb.closeEquip();
    }
}

class Keyboard implements Usb{
    static String name;

    public Keyboard(String name) {
        this.name = name;
    }

    void press(){
        System.out.println("键盘按键");
    }

    public String getName() {
        return name;
    }
}

class Mouse implements Usb{
    static String name;

    public Mouse(String name) {
        this.name = name;
    }

    public static String getName() {
        return name;
    }

    void click(){
        System.out.println("点击鼠标");
    }
}