package classes;

/**
 * IP address utilites
 * @author northway
 */
public class IPUtils implements IPValidator{

    @Override
    public boolean validateIPv4(String address) {
        return false;
    }

    @Override
    public boolean validateIPv6(String address) {
        return false;
    }

    @Override
    public boolean checkULA(String address) {
        return false;
    }
    
    @Override
    public boolean checkLinkLocal(String address) {
        return true;
    }
    
    public static void main(String[] args) {
        
        IPUtils tools = new IPUtils();
        
        System.out.println(tools.checkULA("valami"));
        System.out.println(tools.checkLinkLocal("valami"));
    }
    
}
