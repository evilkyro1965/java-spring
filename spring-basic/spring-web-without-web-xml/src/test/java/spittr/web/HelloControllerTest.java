package spittr.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

/**
 * Created by Administrator on 10/6/15.
 */
public class HelloControllerTest {

    @Test
    public void testHelloPage() throws Exception {
        HelloController controller = new HelloController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/hellopage"))
                .andExpect(view().name("hello"));
    }

}
