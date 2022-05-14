package com.example.demo.shipping.controller;

import com.example.demo.security.AuthenticationService;
import com.example.demo.security.Role;
import com.example.demo.security.User;
import com.example.demo.security.UserService;
import com.example.demo.shipping.dto.RegisterRequestDTO;
import com.example.demo.shipping.dto.ShipmentRequestDTO;
import com.example.demo.shipping.dto.UpdatePasswordRequestDTO;
import com.example.demo.shipping.dto.mapper.PostmanMapper;
import com.example.demo.shipping.dto.mapper.SenderMapper;
import com.example.demo.shipping.dto.mapper.ShipmentMapper;
import com.example.demo.shipping.dto.mapper.UserMapper;
import com.example.demo.shipping.entity.Postman;
import com.example.demo.shipping.entity.Shipment;
import com.example.demo.shipping.entity.Tag;
import com.example.demo.shipping.service.PostmanService;
import com.example.demo.shipping.service.SenderService;
import com.example.demo.shipping.service.ShipmentService;
import com.example.demo.shipping.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ShippingController {

    private final ShipmentService shipmentService;
    private final AuthenticationService authenticationService;
    private final PostmanService postmanService;
    private final SenderService senderService;
    private final TagService tagService;
    private final UserService userService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/403")
    public String accesssDenied() {
        return "unauthorized";
    }

    @GetMapping("/postman")
    @PreAuthorize("hasAuthority('POSTMAN')")
    public String retrieve(Model model) {
        Postman postman = authenticationService.postman();
        List<Shipment> shipmentList = shipmentService.retrieveShipmentsByPostmanId(postman.getId());

        model.addAttribute("message", postman.fullName());
        model.addAttribute("shipmentList", shipmentList);
        return "postman";
    }

    @GetMapping("/sender")
    @PreAuthorize("hasAuthority('SENDER')")
    public String sender(Model model) {
        List<Tag> tagList = tagService.findAll();
        model.addAttribute("tagList", tagList);
        model.addAttribute("shipmentRequestDTO", new ShipmentRequestDTO());
        return "sender";
    }

    @PostMapping("/sender")
    @PreAuthorize("hasAuthority('SENDER')")
    public String createShipment(@ModelAttribute ShipmentRequestDTO shipmentRequestDTO) {
        Long postmanId = postmanService.findAnyId();
        Long senderId = authenticationService.sender().getId();
        shipmentService.save(ShipmentMapper.INSTANCE.toEntity(shipmentRequestDTO, postmanId, senderId));
        return "sendercreated";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerRequestDTO", new RegisterRequestDTO());
        model.addAttribute("roles", Role.values());
        return "register";
    }

    @PostMapping("/register")
    public String createUser(@ModelAttribute @Valid RegisterRequestDTO registerRequestDTO) {
        Long userId;
        if (registerRequestDTO.getRole().equals(Role.POSTMAN)) {
            userId = postmanService.save(PostmanMapper.INSTANCE.toEntity(registerRequestDTO)).getId();
        } else {
            userId = senderService.save(SenderMapper.INSTANCE.toEntity(registerRequestDTO)).getId();
        }
        userService.save(UserMapper.INSTANCE.toEntity(registerRequestDTO, userId));
        return "redirect:/login";
    }

    @GetMapping("/update")
    public String update(Model model) {
        User user = authenticationService.user();
        model.addAttribute("updatePasswordRequestDTO", UserMapper.INSTANCE.toDTO(user));
        return "updatepassword";
    }

    @PostMapping("/update")
    public String createShipment(@ModelAttribute UpdatePasswordRequestDTO updatePasswordRequestDTO) {
        User user = userService.findUserByUsername(updatePasswordRequestDTO.getUsername());
        user.setPassword(updatePasswordRequestDTO.getPassword());
        userService.save(user);
        return "home";
    }
}
