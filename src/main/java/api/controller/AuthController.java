package api.controller;

import java.util.HashMap;
import java.util.Map;

import api.service.inter.IAuthService;
import api.dto.EmployerRegisterDto;
import api.dto.JobSeekerRegisterDto;
import api.utilities.result.ErorDataResult;
import api.utilities.result.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Authentication", description = "Authentication User APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {
    private final IAuthService authService;

    @Autowired
    public AuthController(IAuthService authService) {
        super();
        this.authService = authService;
    }

    @PostMapping("/jobseeker-register")
    public Result jobSeekerRegister(@RequestBody JobSeekerRegisterDto jobSeekerRegisterDto) {
        return this.authService.registerJobSeeker(jobSeekerRegisterDto);
    }

    @PostMapping("/employer-register")
    public Result registerEmployer(@RequestBody EmployerRegisterDto employerRegisterDto) {
        return this.authService.registerEmployer(employerRegisterDto);
    }

    @GetMapping("/verify")
    public Result verify(int userId, String verificationCode) {
        return this.authService.verifyEmail(userId, verificationCode);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ErorDataResult<Object>(validationErrors, "Validation error. Try again ! ");

    }
}
