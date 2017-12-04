package app.dbCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mysql.jdbc.StringUtils;

@Component
public class DBCommandValidator implements Validator {
	@Autowired
	DBCommandDao dBCommandDao;
	
	@Override
	public boolean supports(Class<?> claszz) {
		return DBCommandForm.class.isAssignableFrom(claszz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// typeのエラーがある場合は処理しない
		if(errors.hasFieldErrors("type")) {
			return;
		}
		DBCommandForm form = DBCommandForm.class.cast(target);
		if(!StringUtils.isNullOrEmpty(form.getProductId())) {
			int count = dBCommandDao.findByProductId(form.getProductId());
			// IDが存在する場合
			if(count != 0) {
				errors.rejectValue("duplicateId", "製品IDが重複しています。");
			}
		}
	}
}
