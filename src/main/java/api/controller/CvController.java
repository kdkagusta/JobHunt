package api.controller;

import java.util.HashMap;
import java.util.Map;

import api.service.inter.ICvService;
import api.entities.Cv;
import api.utilities.result.ErorDataResult;
import api.utilities.result.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@Tag(name = "Curriculum vitae", description = "Curriculum vitae Jobseeker APIs")
@RestController
@RequestMapping(name = "/api/cv")
@CrossOrigin
public class CvController {
    private final ICvService cvService;

    @Autowired
    public CvController(ICvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.cvService.getAll());
    }

    @PostMapping("/add")
    public Result add(@RequestBody Cv cv) {
        return this.cvService.add(cv);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam Cv cv) {
        return this.cvService.delete(cv);
    }

    @PutMapping("/update")
    public Result update(@Valid @RequestBody Cv cv) {
        return this.cvService.delete(cv);
    }

    @GetMapping("/getallbyjobseekerid")
    public ResponseEntity<?> getAllByJobSeekerId(@RequestParam(name = "id") int id) {
        return ResponseEntity.ok(this.cvService.getAllByJobSeekerId(id));
    }

    @PostMapping("/uploadphoto")
    public ResponseEntity<?> uploadPhoto(@RequestParam(name = "id") Integer id,
                                         @RequestBody MultipartFile file) {
        return ResponseEntity.ok(this.cvService.uploadImage(id, file));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ErorDataResult<Object>(validationErrors, "Validation Errors");
    }
}
