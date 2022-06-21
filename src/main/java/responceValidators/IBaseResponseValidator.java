package responceValidators;

public interface IBaseResponseValidator {
    boolean validateCode(Integer code);
    boolean validateField(String field, String value);
}
