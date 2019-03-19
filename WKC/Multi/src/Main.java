public class Main {
    public static void main(String[] args) {
        Keyboard kb = new Keyboard("Repoo");
        Usb m = new Mouse("Logitech");

        Labtop lt = new Labtop("Lenovo");

        lt.start();

        lt.useUsbEquip(kb);


        lt.closeUsbEquip(kb);

        lt.useUsbEquip(m);



        lt.closeUsbEquip(m);

        lt.close();


    }

}
