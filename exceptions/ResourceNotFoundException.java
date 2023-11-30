package ma.gov.cmr.echangeaf.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
