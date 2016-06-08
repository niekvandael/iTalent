//package be.italent.web.controller;
//
//import be.italent.model.Project;
//import be.italent.model.buider.ProjectBuilder;
//import be.italent.repository.ProjectRepo;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//
//import java.security.Principal;
//import java.util.Arrays;
//
//import be.italent.security.WithUserDetailsSecurityContextFactory;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.*;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.test.context.TestExecutionListeners;
//
//
//@RunWith(MockitoJUnitRunner.class)
//@TestExecutionListeners(listeners={WithUserDetailsSecurityContextFactory.class})
//
//public class ProjectRestControllerTest {
//
//    private static final Project FIRST_PROJECT = new ProjectBuilder()
//            .projectId(1)
//            .title("titeltje")
//            .shortDescription("omschrijvingtje")
//            .build();
//
//    private ArgumentCaptor anyItem = ArgumentCaptor.forClass(Project.class);
//
//    @InjectMocks
//    private ProjectRestController controller;
//
//    @Mock
//    private ProjectRepo repository;
//
//
//    @Test
//    public void projectTest() throws Exception {
//        given(repository.findOne(1)).willReturn(FIRST_PROJECT);
//
//        assertThat(controller.getProject(1, principal))
//                .isSameAs(FIRST_PROJECT);
//    }
//}


//package be.italent.web.controller;
//
//import be.italent.Italent;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.boot.test.TestRestTemplate;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.web.client.RestTemplate;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(Italent.class)
//public class ProjectRestControllerTest {
//
//    @Autowired
//    ProjectRestController projectRestController;
//
//    @Test(expected = AuthenticationCredentialsNotFoundException.class)
//    public void getMessageUnauthenticated() {
//        projectRestController.getHomeProjects(null);
//    }
//
//
//    RestTemplate template = new TestRestTemplate();
//
//    @Test
//    public void testRequest() throws Exception {
//        HttpHeaders headers = template.getForEntity("http://myhost.com", String.class).getHeaders();
//        assertThat(headers.getLocation().toString(), containsString("myotherhost"));
//    }
//
//}




//package be.italent.web.controller;
//
//import be.italent.model.Project;
//import be.italent.model.buider.ProjectBuilder;
//import be.italent.repository.ProjectRepo;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//
//import java.security.Principal;
//import java.util.Arrays;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.*;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
//@WebAppConfiguration
//public class ProjectRestControllerTest {
//
//    private static final Project FIRST_PROJECT = new ProjectBuilder()
//            .projectId(1)
//            .title("titeltje")
//            .shortDescription("omschrijvingtje")
//            .build();
//
//
//    @Autowired
//    private WebApplicationContext context;
//
//    private MockMvc mvc;
//
//    public void setup() {
//        mvc = MockMvcBuilders
//                .webAppContextSetup(context)
//                .apply(springSecurity())
//                .build();
//    }
//
//    @Test
//    public void projectTest() throws Exception {
//        mvc.perform(post("/"));
//    }
//
//
//}



//package be.italent.web.controller;
//
//        import be.italent.Italent;
//        import be.italent.model.Project;
//        import be.italent.model.buider.ProjectBuilder;
//        import be.italent.repository.ProjectRepo;
//        import be.italent.service.ProjectService;
//        import org.junit.Before;
//        import org.junit.Test;
//        import org.junit.runner.RunWith;
//        import org.mockito.ArgumentCaptor;
//        import org.mockito.InjectMocks;
//        import org.mockito.Mock;
//        import org.mockito.runners.MockitoJUnitRunner;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.boot.test.SpringApplicationConfiguration;
//        import org.springframework.http.MediaType;
//        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//        import org.springframework.test.context.web.WebAppConfiguration;
//        import org.springframework.test.web.servlet.MockMvc;
//        import org.springframework.web.context.WebApplicationContext;
//
//        import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//        import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//        import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
//
//
////@RunWith(SpringJUnit4ClassRunner.class)
////@SpringApplicationConfiguration(classes = Italent.class)
////@WebAppConfiguration
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class ProjectRestControllerTest {
//
////    final String BASE_URL = "http://localhost:8080/";
////    private MockMvc mockMvc;
////
////    @Autowired
////    private WebApplicationContext webApplicationContext;
////
////    @Before
////    public void setup() throws Exception {
////        this.mockMvc = webAppContextSetup(webApplicationContext).build();
////    }
////
////    @Test
////    public void projectNotFound() throws Exception {
//////        mockMvc.perform(get("/project/1")).andExpect(status().isNotFound());
////        mockMvc.perform(get("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
////                .andExpect(status().isOk());
//////                .andExpect(content().contentType("application/json"));
////    }
//
//    private static final Project FIRST_PROJECT = new ProjectBuilder()
//            .projectId(1)
//            .title("titeltje")
//            .shortDescription("omschrijvingtje")
//            .build();
//
//    private ArgumentCaptor anyItem = ArgumentCaptor.forClass(Project.class);
//
//
//    @InjectMocks
//    private ProjectRestController controller;
//
//    @Mock
//    private ProjectRepo repository;
//
//    @Test
//    public void projectTest() throws Exception {
//        given(repository.findOne()).wo
//
//
//    }
//}





//package be.italent.web.controller;
//
//import be.italent.Italent;
//import be.italent.model.Project;
//import be.italent.model.buider.ProjectBuilder;
//import be.italent.repository.ProjectRepo;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//
//import java.security.Principal;
//import java.util.Arrays;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.*;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.security.web.FilterChainProxy;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Italent.class)
//@WebAppConfiguration
//public class ProjectRestControllerTest {
//
//    private static final Project FIRST_PROJECT = new ProjectBuilder()
//            .projectId(1)
//            .title("titeltje")
//            .shortDescription("omschrijvingtje")
//            .build();
//
//    @Autowired
//    public WebApplicationContext context;
//
//    @Autowired
//    private FilterChainProxy springSecurityFilter;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        assertNotNull(context);
//        assertNotNull(springSecurityFilter);
//        // Process mock annotations
//        MockitoAnnotations.initMocks(this);
//        // Setup Spring test in webapp-mode (same config as spring-boot)
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
//                .addFilters(springSecurityFilter)
//                .build();
//        context.getServletContext().setAttribute(
//                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);
//    }
//
//
//    @Test
//    public void projectTest() throws Exception {
//        given(repository.findOne(1)).willReturn(FIRST_PROJECT);
//
//        assertThat(controller.getProject(1, principal))
//                .isSameAs(FIRST_PROJECT);
//    }
//}




