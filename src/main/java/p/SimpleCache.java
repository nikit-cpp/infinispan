package p;

import org.infinispan.manager.EmbeddedCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;

/**
 * Created by nik on 08.11.15.
 */
@Startup
@Singleton
public class SimpleCache {
    @Resource(lookup = "java:jboss/infinispan/container/myCache")
    private EmbeddedCacheManager defaultCacheManager;

    private Logger logger = LoggerFactory.getLogger("mylog");

    private org.infinispan.Cache<String, String> cache;

    @PostConstruct
    public void initCache() {
        this.cache = defaultCacheManager.getCache();

        final String key = "key";
        String result = get(key);
        logger.info("getted result 1: {}", result);

        put(key, "ololo");

        result = get(key);
        logger.info("getted result 1: {}", result);

    }

    public String get(String key) {
        return this.cache.get(key);
    }

    public void put(String key, String value) {
        this.cache.put(key, value);
    }

}