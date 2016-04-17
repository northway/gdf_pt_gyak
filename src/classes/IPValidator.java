package classes;

/**
 * IP address validator interface
 * @author northway
 */
public interface IPValidator {

    /**
     * Validate if given parameter is a valid IPv4 address.
     * @param address String
     * @return boolean
     */
    boolean validateIPv4(String address);
    
    /**
     * Validate if given parameter is a valid IPv6 address.
     * @param address String
     * @return boolean
     */
    boolean validateIPv6(String address);
    
    /**
     * Validate if given address is a IPv6 Unique Local Address.
     * @param address String
     * @return boolean
     */
    boolean checkULA(String address);
    
    /**
     * Validate if given address is a IPv6 link-local address.
     * @param address
     * @return 
     */
    boolean checkLinkLocal(String address);

}
