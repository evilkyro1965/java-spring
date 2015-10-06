import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spittr.Spittle;
import spittr.data.SpittleRepository;
import spittr.web.SpittleController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Administrator on 10/6/15.
 */
public class SpittleControllerTest {

    @Test
    public void testSpittleList() throws Exception {
        List<Spittle> spittleList = createSpittleList(10);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(1000000,20))
                .thenReturn(spittleList);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittleView"))
                .andExpect(model().attribute("spittleList",hasItems(spittleList.toArray())));
    }

    @Test
    public void testSpittleListWithUrlQuery() throws Exception {
        List<Spittle> spittleList = createSpittleList(10);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(1000000,20))
                .thenReturn(spittleList);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittles?max=1000000&count=20"))
                .andExpect(view().name("spittleView"))
                .andExpect(model().attribute("spittleList",hasItems(spittleList.toArray())));
    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i=0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }
}
