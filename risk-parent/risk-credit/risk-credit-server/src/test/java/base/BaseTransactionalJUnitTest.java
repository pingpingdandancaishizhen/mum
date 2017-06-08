package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

@ContextConfiguration(locations = { "classpath:test_config.xml", "classpath:test_cache.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseTransactionalJUnitTest extends AbstractTransactionalJUnit4SpringContextTests {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
}
