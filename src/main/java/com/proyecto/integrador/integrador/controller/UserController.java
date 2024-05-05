package com.proyecto.integrador.integrador.controller;

import com.proyecto.integrador.integrador.dto.UserDto;
import com.proyecto.integrador.integrador.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuarios", description = "Endpoints para trabajar con Usuarios ")
public class UserController {

    private final UserService usersService;

    public UserController(@Autowired UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("{id}")
    @Operation(summary = "Obtener por ID", description = "Obtener un Usuario por el atributo ID", responses = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = UserDto.class)))}
    )
    public ResponseEntity<UserDto> findById(@PathVariable("id") final Long id) {
        return ResponseEntity.ok(this.usersService.findById(id));
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Obtener todos los Usuarios", responses = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = UserDto.class)))}
    )
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(this.usersService.all());
    }

    @PostMapping
    @Operation(summary = "Crear", description = "Crear un Usuario nuevo", responses = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = UserDto.class)))}
    )
    public ResponseEntity<UserDto> createUser(@RequestBody final UserDto user) {
        return ResponseEntity.ok().body(this.usersService.save(user));
    }

    @PutMapping("{id}")
    @Operation(summary = "Actualizar", description = "Actualizar un Usuario por el atributo ID", responses = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = UserDto.class)))}
    )
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") final Long id, @RequestBody final UserDto user) {
        return ResponseEntity.ok(this.usersService.update(user, id));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Eliminar", description = "Eliminar un Usuario por el atributo ID", responses = {
            @ApiResponse(responseCode = "204", description = "Operación exitosa")}
    )
    public ResponseEntity<Void> deleteUser(@PathVariable("id") final Long id) {
        this.usersService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
