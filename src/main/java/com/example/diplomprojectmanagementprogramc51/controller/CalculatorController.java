package com.example.diplomprojectmanagementprogramc51.controller;

import com.example.diplomprojectmanagementprogramc51.converter.OperationDTOConverter;
import com.example.diplomprojectmanagementprogramc51.dto.OperationDTO;
import com.example.diplomprojectmanagementprogramc51.entity.Operation;
import com.example.diplomprojectmanagementprogramc51.entity.User;
import com.example.diplomprojectmanagementprogramc51.repository.OperationRepository;
import com.example.diplomprojectmanagementprogramc51.repository.UserRepository;
import com.example.diplomprojectmanagementprogramc51.service.CalculatorService;
import com.example.diplomprojectmanagementprogramc51.service.OperationService;
import com.example.diplomprojectmanagementprogramc51.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/calc")
public class CalculatorController {

    private final OperationService operationService;

    private CalculatorService calculatorService;

    private final OperationDTOConverter operationDTOConverter;

    private final OperationRepository operationRepository;

    private final UserService userService;

    private final UserRepository userRepository;

    public CalculatorController(OperationService operationService, OperationRepository operationRepository, OperationDTOConverter operationDTOConverter, CalculatorService calculatorService, UserService userService, UserRepository userRepository) {
        this.operationService = operationService;
        this.operationRepository = operationRepository;
        this.operationDTOConverter = operationDTOConverter;
        this.calculatorService = calculatorService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String calc(@ModelAttribute("calcOperation") Operation operation) {
        return "calculator/calc";
    }

    @PostMapping
    public String result(@Valid @ModelAttribute("calcOperation") OperationDTO operationDTO,
                         BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "calculator/calc";
        }

        User user = userRepository.findByUsername(userService.getCurrentUsername()).get();
        Operation operation = operationDTOConverter.operationDTOtoOperation(operationDTO);
        operation.setResult(calculatorService.getResult(operation));
        operation.setUser(user);
        operationService.save(operation);

        model.addAttribute("msgResult", operation.getResult());

        return "calculator/calc";
    }

    @GetMapping("/history")
    public String history(Model model) {

        model.addAttribute("userHistory", operationRepository.findAllByUser(userService.getCurrentUser()));

        return "calculator/history";
    }
}
