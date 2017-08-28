package cn.ljaer.ssm.redis;

/**
 * Created by songzw on 17/8/1.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.Set;

import javax.annotation.Resource;

@Service("utilJedis")
public class UtilJedis {

	@Resource(name = "jedisCluster")
	JedisCluster jedisCluster;

	private static Logger logger = LoggerFactory.getLogger(UtilJedis.class);
//	public static final int HENGHUIRONG_SIGN_KEY_EXPIRE_TIME = 1800;
	public static final int REDIS_TIMEOUT = 1800;
//	private static String keyPrefix = "CRMCS_";
	
	public  String get(String key) {
		String result = null;
		if (key == null)
			return result;
		try {
			result = jedisCluster.get(key);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:Get({})方法异常", key, e);
		}
		return result;
	}

	 /**
     * 添加一个或多个指定的member元素到集合的 key中.指定的一个或者多个元素member 如果已经在集合key中存在则忽略.如果集合key
     * 不存在，则新建集合key,并添加member元素到集合key中.
     * 
     * 如果key 的类型不是集合则返回错误.
     *
     * @param key
     * @param member
     * @return 返回新成功添加到集合里元素的数量，不包括已经存在于集合中的元素.
     */
	public Long sadd(String key, String member) {
		Long result = null;
		try {
			result = jedisCluster.sadd(key, member);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:sadd({},{})异常", key, member, e);
		}
		return result;
	}
	public Long sadd(String key, String[] members) {
		Long result = null;
		try {
			result = jedisCluster.sadd(key, members);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:sadd({},{})异常", key, members, e);
		}
		return result;
	}

	 /**
     * 返回key集合所有的元素.
     * 
     * 该命令的作用与使用一个参数的SINTER 命令作用相同.
     *
     * @param key
     * @return 集合中的所有元素.
     */
	public Set<String> smembers(String key) {
		Set<String> result = null;
		try {
			result = jedisCluster.smembers(key);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:smembers({})异常", key, e);
		}
		return result;
	}
	
	 /**
     * 在key集合中移除指定的元素. 如果指定的元素不是key集合中的元素则忽略 如果key集合不存在则被视为一个空的集合，该命令返回0.
     * 
     * 如果key的类型不是一个集合,则返回错误.
     *
     * @param key
     * @param member
     * @return 从集合中移除元素的个数，不包括不存在的成员.
     */
	public Long srem(String key, String... member){
		
		return null;
	}
	
	  /**
     * 返回集合存储的key的基数 (集合元素的数量).
     *
     * @param key
     * @return 集合的基数(元素的数量),如果key不存在,则返回 0.
     */
	public Long scard(String key){
		Long result = null;
		try {
			result = jedisCluster.scard(key);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:scard({})异常", key, e);
		}
		return result;
	}
	
	  /**
     * 返回成员 member 是否是存储的集合 key的成员.
     *
     * @param key
     * @param member
     * @return 如果member元素是集合key的成员，则返回1.如果member元素不是key的成员，或者集合key不存在，则返回0
     */
	public Boolean sismember(String key, String member){
		Boolean result = null;
		try {
			result = jedisCluster.sismember(key, member);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:sismember({},{})异常", key, member, e);
		}
		return result;
	}

	
	public Long expire(String key, Integer seconds) {
		Long result = null;
		try {
			result = jedisCluster.expire(key, seconds);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:expire({},{})异常", key, seconds, e);
		}
		return result;
	}
	
	
	public  String set(String key, String value) {
		String result = null;
		try {
			result = jedisCluster.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:Set({},{})异常", key, value, e);
		}
		return result;
	}

	public String set(String key, String value, int seconds) {

		String result = null;

		try {
			result = jedisCluster.setex(key, seconds, value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:Setex()异常", e);
		}
		return result;
	}

	public Long setnx(String key, String value) {
		Long result = null;
		try {
			result = jedisCluster.setnx(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:Setex()异常", e);
		}
		return result;
	}

	public  Long del(String key) {

		Long result = null;
		try {
			result = jedisCluster.del(key);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:Del()异常", e);
		}
		return result;
	}	
	public  boolean exists(String key){
		Boolean result = null;
		
		try {
			result =  jedisCluster.exists(key);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("jediscluster:Del()异常", e);
		}
		return result;
	}
	public  void close(){
		
		try {
			jedisCluster.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}