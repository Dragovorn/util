package com.dragovorn.util.lang;

import com.google.common.base.Splitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * A Localization Library that can read in localization files and
 * add them to a key value map for translation lookups.
 *
 * @author Andrew Burr
 * @since 0.0.2
 * @version 1.2
 */
public class Locale {

    private static final Splitter splitter = Splitter.on('=').limit(2);

    private static final Pattern pattern = Pattern.compile("%(\\\\d+\\\\$)?[\\\\d\\\\.]*[df]");

    private final Map<String, String> properties;

    private final String name;

    public Locale(String path, String name) {
        
        this.properties = new HashMap<>();
        this.name = name;

        try(InputStream stream = Locale.class.getResourceAsStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> str = splitter.splitToList(line);

                if (str.size() == 2) {
                    String key = str.get(0);
                    String value = pattern.matcher(str.get(1)).replaceAll("%s$1s");
                    this.properties.put(key, value);
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Translates and formats the given key by looking to see
     * if it has a corresponding entry in the map
     * if no translation is found the key will be returned
     *
     * @param key
     * @param objs
     * @return
     */
    public String translate(String key, Object... objs) {
        String translate = this.properties.get(key);

        if (translate == null) {
            translate = key;
        }

        return MessageFormat.format(translate, objs);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return this.properties.hashCode() + this.name.hashCode();
    }

    @Override
    public String toString() {
        return getName();
    }
}
