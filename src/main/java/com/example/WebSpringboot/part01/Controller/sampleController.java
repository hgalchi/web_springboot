package com.example.WebSpringboot.part01.Controller;

import com.example.WebSpringboot.part01.dto.SampleDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/sample")
@Log4j2
public class sampleController {

    @GetMapping("/ex1")
    public String ex1() {
        log.info("ex1............");

        return "ex1";
    }

    @GetMapping("/ex2")
    public String exModel(Model model) {
        List<SampleDto> list = IntStream.range(1, 20).asLongStream().
                mapToObj(i -> {
                    SampleDto dto = SampleDto.builder()
                            .sno(i)
                            .first("First" + i)
                            .last("Last" + i)
                            .regtime(LocalDateTime.now())
                            .build();
                    return dto;
                }).collect(Collectors.toList());
        model.addAttribute("list", list);

        return "ex2";
    }


    @GetMapping({"/exInline"})
    public String exInline(RedirectAttributes redirectAttributes) {

        log.info(("exInline........"));

        SampleDto dto=SampleDto.builder()
                .sno(100L)
                .first("First-100")
                .last("Last-100" )
                .regtime(LocalDateTime.now())
                .build();
        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addFlashAttribute("dto", dto);

        return "redirect:/ex3";
    }

    public void ex3(){
        log.info("ex3");
    }
}
