package spittr.web;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import spittr.Spitter;
import spittr.data.SpitterRepository;
import spittr.web.SpitterController;

public class SpitterControllerTest {

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "", "Jack", "Bauer", "");
        Spitter saved = new Spitter(24L, "jbauer", "", "Jack", "Bauer", "");
        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "")
                .param("email", ""))
                .andExpect(model().attributeHasFieldErrors("spitter","password"))
                .andExpect(model().attributeHasFieldErrors("spitter","email"));

        //verify(mockRepository, atLeastOnce()).save(unsaved);
    }


}
