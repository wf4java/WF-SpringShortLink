package wf.spring.short_link.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import wf.spring.short_link.dto.app.link.LinkResponseDTO;
import wf.spring.short_link.models.entities.Link;
import wf.spring.short_link.utils.EncodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class LinkMapperTest {

    @InjectMocks
    private LinkMapper linkMapper;

    @Mock
    private EncodeUtils encodeUtils;

    private Link link;
    private LinkResponseDTO linkResponseDTO;

    @BeforeEach
    public void setUp() {
        link = new Link();
        link.setId(1L);
        link.setLink("https://example.com");
        link.setVisits(10L);
        link.setCreatedAt(new Date());

        linkResponseDTO = new LinkResponseDTO();
        linkResponseDTO.setId(link.getId());
        linkResponseDTO.setLink(link.getLink());
        linkResponseDTO.setVisits(link.getVisits());
        linkResponseDTO.setCreatedAt(link.getCreatedAt());
        linkResponseDTO.setShortLink("encodedLink");

        when(encodeUtils.encode(link.getId())).thenReturn("encodedLink");
    }

    @Test
    public void testToLinkResponseDTOWhenLinkProvidedThenCorrectlyMapsToLinkResponseDTO() {
        LinkResponseDTO result = linkMapper.toLinkResponseDTO(link);

        assertEquals(linkResponseDTO.getId(), result.getId());
        assertEquals(linkResponseDTO.getLink(), result.getLink());
        assertEquals(linkResponseDTO.getVisits(), result.getVisits());
        assertEquals(linkResponseDTO.getCreatedAt(), result.getCreatedAt());
        assertEquals(linkResponseDTO.getShortLink(), result.getShortLink());
    }

    @Test
    public void testToLinkResponseDTOListWhenLinkListProvidedThenCorrectlyMapsToLinkResponseDTOList() {
        List<Link> links = Arrays.asList(link, link);
        List<LinkResponseDTO> expected = Arrays.asList(linkResponseDTO, linkResponseDTO);

        List<LinkResponseDTO> result = linkMapper.toLinkResponseDTOList(links);

        assertEquals(expected, result);
    }

    @Test
    public void testToLinkResponseDTOListWhenEmptyLinkListProvidedThenReturnsEmptyList() {
        List<Link> links = new ArrayList<>();
        List<LinkResponseDTO> expected = new ArrayList<>();

        List<LinkResponseDTO> result = linkMapper.toLinkResponseDTOList(links);

        assertTrue(result.isEmpty());
        assertEquals(expected, result);
    }

    @Test
    public void testToLinkResponseDTOListWhenNullLinkListProvidedThenReturnsNull() {
        List<Link> links = null;

        List<LinkResponseDTO> result = linkMapper.toLinkResponseDTOList(links);

        assertNull(result);
    }
}