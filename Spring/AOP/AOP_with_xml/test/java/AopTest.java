import src.com.qfedu.spring.aop.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {
    @Resource(name="userService")
    private UserService userService;

    @Test
    public void testUpdate() {
        userService.update();
    }
}
