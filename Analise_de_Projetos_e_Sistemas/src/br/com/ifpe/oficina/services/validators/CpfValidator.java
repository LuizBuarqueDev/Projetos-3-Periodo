package br.com.ifpe.oficina.services.validators;

import br.com.caelum.stella.validation.CPFValidator;

public class CpfValidator implements ICpfValidator {

    private final CPFValidator cpfValidator = new CPFValidator();

    @Override
    public boolean validateCpf(String cpf) {
        try {
            cpfValidator.assertValid(cpf);
            return  true;
        } catch (Exception e) {
            return  false;
        }
    }
}
