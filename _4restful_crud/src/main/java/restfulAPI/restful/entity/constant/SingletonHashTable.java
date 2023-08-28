package restfulAPI.restful.entity.constant;

import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
@Component
public class SingletonHashTable {

    public SingletonHashTable(){
        System.out.println("CREATE SINGLETON HASHTABLE");
    }

    private Map listCache = new Hashtable();

    public void reload() {
        listCache = new Hashtable();
    }

    public Hashtable getHashtable(String key)
    {
        if (this.listCache.get(key) == null) {
            return null;
        }
        return (Hashtable)this.listCache.get(key);
    }

    public void setHashtable(String key, Hashtable data)
    {
        this.listCache.put(key, data);
    }

    public String getString(String key)
    {
        if (this.listCache.get(key) == null) {
            return null;
        }
        return this.listCache.get(key).toString();
    }

    public void setString(String key, String data)
    {
        this.listCache.put(key, data);
    }

    public Object getObject(String key)
    {
        if (this.listCache.get(key) == null) {
            return null;
        }
        return this.listCache.get(key);
    }

    public void setObject(String key, Object data)
    {
        this.listCache.put(key, data);
    }

    public List<String> getListString(String key)
    {
        if (this.listCache.get(key) == null) {
            return null;
        }
        return (List<String>) this.listCache.get(key);
    }

    public void setListString(String key, List<String> data)
    {
        this.listCache.put(key, data);
    }

    public Map getListCache() {
        return listCache;
    }
}