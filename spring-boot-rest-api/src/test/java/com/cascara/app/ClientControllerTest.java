package com.cascara.app;
import com.cascara.app.controller.ClientController;
import com.cascara.app.model.Client;
import com.cascara.app.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClientControllerTest {

    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllClients() {
        List<Client> clients = Arrays.asList(new Client(), new Client());
        when(clientService.findAll()).thenReturn(clients);

        ResponseEntity<List<Client>> response = clientController.getAllClients();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clients, response.getBody());
        verify(clientService, times(1)).findAll();
    }

    @Test
    public void testGetClientById() {
        Client client = new Client();
        when(clientService.findById(1L)).thenReturn(client);

        ResponseEntity<Client> response = clientController.getClientById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(client, response.getBody());
        verify(clientService, times(1)).findById(1L);
    }

    @Test
    public void testGetClientByIdNotFound() {
        when(clientService.findById(1L)).thenReturn(null);

        ResponseEntity<Client> response = clientController.getClientById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(clientService, times(1)).findById(1L);
    }

    @Test
    public void testCreateClient() {
        Client client = new Client();
        when(clientService.save(client)).thenReturn(client);

        ResponseEntity<Client> response = clientController.createClient(client);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(client, response.getBody());
        verify(clientService, times(1)).save(client);
    }

    @Test
    public void testUpdateClient() {
        Client client = new Client();
        when(clientService.update(1L, client)).thenReturn(client);

        ResponseEntity<Client> response = clientController.updateClient(1L, client);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(client, response.getBody());
        verify(clientService, times(1)).update(1L, client);
    }

    @Test
    public void testUpdateClientNotFound() {
        Client client = new Client();
        when(clientService.update(1L, client)).thenReturn(null);

        ResponseEntity<Client> response = clientController.updateClient(1L, client);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(clientService, times(1)).update(1L, client);
    }

    @Test
    public void testDeleteClient() {
        when(clientService.delete(1L)).thenReturn(true);

        ResponseEntity<Void> response = clientController.deleteClient(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(clientService, times(1)).delete(1L);
    }

    @Test
    public void testDeleteClientNotFound() {
        when(clientService.delete(1L)).thenReturn(false);

        ResponseEntity<Void> response = clientController.deleteClient(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(clientService, times(1)).delete(1L);
    }
}
