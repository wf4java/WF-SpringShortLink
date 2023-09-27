package wf.spring.short_link.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import wf.spring.short_link.dto.ErrorMessageResponseDTO;
import wf.spring.short_link.dto.app.link.CreateLinkRequestDTO;
import wf.spring.short_link.dto.app.link.LinkResponseDTO;
import wf.spring.short_link.mappers.LinkMapper;
import wf.spring.short_link.models.entities.Link;
import wf.spring.short_link.models.entities.Person;
import wf.spring.short_link.models.exceptions.*;
import wf.spring.short_link.services.LinkService;

@RestController
@RequestMapping("/api/link")
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;
    private final LinkMapper linkMapper;



    @PostMapping("/create")
    public LinkResponseDTO create(@RequestBody @Valid CreateLinkRequestDTO createLinkRequestDTO, BindingResult bindingResult, @AuthenticationPrincipal Person principal) {
        if(bindingResult.hasErrors())
            throw new BadRequestException(bindingResult);

        Link link = linkService.create(principal.getId(), createLinkRequestDTO.getLink());

        return linkMapper.toLinkResponseDTO(link);
    }



















    @ExceptionHandler({NotFoundException.class, BadRequestException.class, AccessException.class, ConflictException.class})
    private ResponseEntity<ErrorMessageResponseDTO> exceptionHandler(HttpException e){
        return new ResponseEntity<>(new ErrorMessageResponseDTO(e.getMessage()), e.getHttpStatus());
    }


}
