package br.com.ifpe.oficina.services.validators;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.ifpe.oficina.interfaces.ICpfValidator;

public class CpfValidator implements ICpfValidator {

    CPFValidator cpfValidator = new CPFValidator();

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
