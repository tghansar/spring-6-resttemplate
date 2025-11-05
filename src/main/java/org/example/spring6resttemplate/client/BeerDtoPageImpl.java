////package org.example.spring6resttemplate.client;
////
////import com.fasterxml.jackson.annotation.JsonCreator;
////import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
////import com.fasterxml.jackson.annotation.JsonProperty;
////import org.example.spring6resttemplate.model.BeerDto;
////import org.springframework.data.domain.PageImpl;
////import org.springframework.data.domain.PageRequest;
////import org.springframework.data.domain.Pageable;
////
////import java.util.Collections;
////import java.util.List;
////import java.util.Map;
////
//////@JsonIgnoreProperties(ignoreUnknown = true, value = "pageable")
//////public class BeerDtoPageImpl<BeerDto> extends PageImpl<BeerDto> {
//////
//////    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
//////    public BeerDtoPageImpl(@JsonProperty("size") int size,
//////                           @JsonProperty("number") int page,
//////                           @JsonProperty("totalElements") long total,
//////                           @JsonProperty("content") List<BeerDto> content) {
//////        super(content, PageRequest.of(page, size), total);
//////    }
//////
//////    public BeerDtoPageImpl(List<BeerDto> content, Pageable pageable, long total) {
//////        super(content, pageable, total);
//////    }
//////
//////    public BeerDtoPageImpl(List<BeerDto> content) {
//////        super(content);
//////    }
//////}
////
////
////@JsonIgnoreProperties(ignoreUnknown = true, value = "pageable")
////public class BeerDtoPageImpl<BeerDto> extends PageImpl<BeerDto> {
////
////    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
////    public BeerDtoPageImpl(@JsonProperty("content") List<BeerDto> content,
////                           @JsonProperty("number") int number,
////                           @JsonProperty("size") int size,
////                           @JsonProperty("totalElements") long totalElements,
////                           @JsonProperty("pageable") Map<String, Object> pageable) {
////        super(content, PageRequest.of(number, size), totalElements);
////    }
////
////    public BeerDtoPageImpl(List<BeerDto> content, Pageable pageable, long total) {
////        super(content, pageable, total);
////    }
////
////    public BeerDtoPageImpl(List<BeerDto> content) {
////        super(content);
////    }
////}
//
//// java
//package org.example.spring6resttemplate.client;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import org.example.spring6resttemplate.model.BeerDto;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
//@JsonIgnoreProperties(ignoreUnknown = true, value = { "pageable", "secretKey", "createdDate", "lastModifiedDate"})
//public class BeerDtoPageImpl extends PageImpl<BeerDto> {
//
//    public BeerDtoPageImpl() {
//        super(Collections.emptyList());
//    }
//
//    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
//    public BeerDtoPageImpl(
//            @JsonProperty("_embedded") Map<String, List<BeerDto>> embedded,
//            @JsonProperty("page") PageMetadata page) {
//
//        super(
//                // content: embedded.beers or empty list
//                embedded != null ? embedded.getOrDefault("beers", Collections.emptyList()) : Collections.emptyList(),
//                // pageable: ensure size >= 1
//                PageRequest.of(page != null ? page.number : 0,
//                        Math.max(1, page != null ? page.size : 1)),
//                // totalElements: from page if present, otherwise size of content
//                page != null ? page.totalElements :
//                        (long) (embedded != null ? embedded.getOrDefault("beers", Collections.emptyList()).size() : 0)
//        );
//    }
//
//    public BeerDtoPageImpl(List<BeerDto> content, Pageable pageable, long total) {
//        super(content, pageable, total);
//    }
//
//    public BeerDtoPageImpl(List<BeerDto> content) {
//        super(content);
//    }
//
//    private static class PageMetadata {
//        final int size;
//        final long totalElements;
//        final long totalPages;
//        final int number;
//
//        @JsonCreator
//        PageMetadata(@JsonProperty("size") int size,
//                     @JsonProperty("totalElements") long totalElements,
//                     @JsonProperty("totalPages") int totalPages,
//                     @JsonProperty("number") int number) {
//            this.size = size;
//            this.totalElements = totalElements;
//            this.totalPages = totalPages;
//            this.number = number;
//        }
//    }
//}
