package wf.spring.short_link.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import wf.spring.short_link.dto.ErrorMessageResponseDTO;
import wf.spring.short_link.dto.app.link.*;
import wf.spring.short_link.mappers.LinkMapper;
import wf.spring.short_link.models.entities.Link;
import wf.spring.short_link.models.entities.Person;
import wf.spring.short_link.models.exceptions.*;
import wf.spring.short_link.services.LinkService;
import wf.spring.short_link.utils.EncodeUtils;

import java.util.List;

@RestController
@RequestMapping("/api/link")
@RequiredArgsConstructor
public class LinkController {

    private final EncodeUtils encodeUtils;
    private final LinkService linkService;
    private final LinkMapper linkMapper;



    @PostMapping("/create")
    public LinkResponseDTO create(@RequestBody @Valid LinkCreateRequestDTO linkCreateRequestDTO, BindingResult bindingResult, @AuthenticationPrincipal Person principal) {
        if(bindingResult.hasErrors())
            throw new BadRequestException(bindingResult);

        Link link = linkService.create(principal.getId(), linkCreateRequestDTO.getLink());

        return linkMapper.toLinkResponseDTO(link);
    }

    @DeleteMapping
    public void delete(@RequestBody @Valid LinkDeleteRequestDTO linkDeleteRequestDTO, BindingResult bindingResult, @AuthenticationPrincipal Person principal) {
        if(bindingResult.hasErrors())
            throw new BadRequestException(bindingResult);

        linkService.deleteById(linkDeleteRequestDTO.getId(), principal.getId());
    }

    @GetMapping("/get_my")
    public List<LinkResponseDTO> getMyLinks(@RequestBody @Valid LinkGetMyRequestDTO linkGetMyRequestDTO, BindingResult bindingResult, @AuthenticationPrincipal Person principal) {
        if(bindingResult.hasErrors())
            throw new BadRequestException(bindingResult);

        List<Link> myLinks = linkService.findAllNextByOwnerIdAndLinkOffset(principal.getId(),
                linkGetMyRequestDTO.getOffSetLinkId(), linkGetMyRequestDTO.getLimit());

        return linkMapper.toLinkResponseDTOList(myLinks);
    }


    @GetMapping("/get_by_short_link")
    public LinkResponseDTO getByShortLink(@RequestBody @Valid LinkGetByShortLinkRequestDTO linkGetByShortLinkRequestDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            throw new BadRequestException(bindingResult);

        Link link = linkService.getById(encodeUtils.decode(linkGetByShortLinkRequestDTO.getShortLink()));
        linkService.addVisit(link.getId());

        return linkMapper.toLinkResponseDTO(link);
    }



















    @ExceptionHandler({NotFoundException.class, BadRequestException.class, AccessException.class, ConflictException.class})
    private ResponseEntity<ErrorMessageResponseDTO> exceptionHandler(HttpException e){
        return new ResponseEntity<>(new ErrorMessageResponseDTO(e.getMessage()), e.getHttpStatus());
    }


}
