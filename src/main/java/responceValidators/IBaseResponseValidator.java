package responceValidators;

public interface IBaseResponseValidator
{
    Boolean validateCode(Integer code);
    Boolean validateField(String field, String value);
}
