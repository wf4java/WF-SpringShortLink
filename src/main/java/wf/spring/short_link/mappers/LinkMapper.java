package wf.spring.short_link.mappers;

import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import wf.spring.short_link.dto.app.link.LinkResponseDTO;
import wf.spring.short_link.models.entities.Link;
import wf.spring.short_link.utils.EncodeUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LinkMapper {


    private final EncodeUtils encodeLinkUtils;


    public LinkResponseDTO toLinkResponseDTO(@NonNull Link link) {
        LinkResponseDTO linkResponseDTO = new LinkResponseDTO();

        linkResponseDTO.setId(link.getId());
        linkResponseDTO.setLink(link.getLink());
        linkResponseDTO.setVisits(link.getVisits());
        linkResponseDTO.setCreatedAt(link.getCreatedAt());

        linkResponseDTO.setShortLink(encodeLinkUtils.encode(link.getId()));

        return linkResponseDTO;
    }

    public List<LinkResponseDTO> toLinkResponseDTOList(@NonNull List<Link> link) {
        return link.stream().map(this::toLinkResponseDTO).toList();
    }









}
