package br.com.fernandoguide.employeeservice.controller.impl;

import br.com.fernandoguide.employeeservice.entity.Company;
import br.com.fernandoguide.employeeservice.mapper.CompanyMapper;
import br.com.fernandoguide.employeeservice.service.CompanyService;
import br.com.fernandoguide.employeeservice.util.CompanyBuilder;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CompanyControllerImplTest {
    private static final String ENDPOINT_URL = "/api/company";

    @InjectMocks
    private CompanyControllerImpl companyController;
    @Mock
    private CompanyService companyService;
    @Mock
    private CompanyMapper companyMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.companyController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(companyMapper.asDTOList(ArgumentMatchers.any())).thenReturn(CompanyBuilder.getListDTO());

        Mockito.when(companyService.findAll()).thenReturn(CompanyBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(companyMapper.asDTO(ArgumentMatchers.any())).thenReturn(CompanyBuilder.getDTO());

        Mockito.when(companyService.findById(ArgumentMatchers.anyInt())).thenReturn(java.util.Optional.of(CompanyBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(companyService, Mockito.times(1)).findById(1);
        Mockito.verifyNoMoreInteractions(companyService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(companyMapper.asEntity(ArgumentMatchers.any())).thenReturn(CompanyBuilder.getEntity());
        Mockito.when(companyService.save(ArgumentMatchers.any(Company.class))).thenReturn(CompanyBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(CompanyBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(companyService, Mockito.times(1)).save(ArgumentMatchers.any(Company.class));
        Mockito.verifyNoMoreInteractions(companyService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(companyMapper.asEntity(ArgumentMatchers.any())).thenReturn(CompanyBuilder.getEntity());
        Mockito.when(companyService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInt())).thenReturn(CompanyBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(CompanyBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(companyService, Mockito.times(1)).update(ArgumentMatchers.any(Company.class), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(companyService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(companyService).deleteById(ArgumentMatchers.anyInt());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(companyService, Mockito.times(1)).deleteById(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(companyService);
    }
}