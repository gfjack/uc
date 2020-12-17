package com.edu.uc.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.Assert;
import sun.util.ResourceBundleEnumeration;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @author vime
 * @since 0.9.6
 */
public class SR {

  private static SR provider;

  static {
    provider = new SR();
  }

  public static void setProvider(SR provider) {
    SR.provider = provider;
  }

  public static SR getProvider() {
    return provider;
  }

  public static String getString(String name) {
    if (StringUtils.isEmpty(name)) {
      return name;
    }
    if (name.startsWith("resource:")) {
      name = name.substring(9).trim();
    }
    List<ResourceBundle> resourceBundles = provider.getResourceBundles();
    for (ResourceBundle resourceBundle : resourceBundles) {
      if (resourceBundle.containsKey(name)) {
        return resourceBundle.getString(name);
      }
    }
    return name;
  }

  public static String getString(Locale locale, String name) {
    if (StringUtils.isEmpty(name)) {
      return name;
    }
    Assert.notNull(locale);

    if (name.startsWith("resource:")) {
      name = name.substring(9).trim();
    }
    List<ResourceBundle> resourceBundles = provider.getResourceBundles(locale);
    for (ResourceBundle resourceBundle : resourceBundles) {
      if (resourceBundle.containsKey(name)) {
        return resourceBundle.getString(name);
      }
    }
    return name;
  }

  public static boolean containsKey(String name) {
    List<ResourceBundle> resourceBundles = provider.getResourceBundles();
    for (ResourceBundle resourceBundle : resourceBundles) {
      if (resourceBundle.containsKey(name)) {
        return true;
      }
    }
    return false;
  }

  public static boolean containsKey(Locale locale, String name) {
    List<ResourceBundle> resourceBundles = provider.getResourceBundles(locale);
    for (ResourceBundle resourceBundle : resourceBundles) {
      if (resourceBundle.containsKey(name)) {
        return true;
      }
    }
    return false;
  }

  public ResourceBundle getResourceBundle() {
    Locale locale = getDefaultLocale();
    MultiControl multiControl = new MultiControl();
    ResourceBundle resourceBundle =
        ResourceBundle.getBundle("timetable_resource", locale, multiControl);
    return resourceBundle;
  }

  public ResourceBundle getResourceBundle(Locale locale) {
    return ResourceBundle.getBundle("timetable_resource", locale, new MultiControl());
  }

  public List<ResourceBundle> getResourceBundles() {
    return Arrays.asList(getResourceBundle());
  }

  public List<ResourceBundle> getResourceBundles(Locale locale) {
    return Arrays.asList(getResourceBundle(locale));
  }

  protected Locale getDefaultLocale() {
    return LocaleContextHolder.getLocale();
  }

  private static class MultiControl extends ResourceBundle.Control {
    @Override
    public ResourceBundle newBundle(
        String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
        throws IllegalAccessException, InstantiationException, IOException {
      String bundleName = toBundleName(baseName, locale);
      String resourceName = toResourceName(bundleName, "properties");

      List<URL> resources = Collections.list(loader.getResources(resourceName));
      Collections.reverse(resources);
      return new MultiResourcePropertyResourceBundle(resources);
    }
  }

  private static class MultiResourcePropertyResourceBundle extends ResourceBundle {
    private final HashMap lookup;

    public MultiResourcePropertyResourceBundle(List<URL> urls) throws IOException {
      lookup = new HashMap();
      for (URL url : urls) {
        URLConnection urlc = url.openConnection();
        InputStream is = urlc.getInputStream();
        try {
          Properties temp = new Properties();
          temp.load(is);
          lookup.putAll(temp);
        } finally {
          is.close();
        }
      }
    }

    @Override
    protected Object handleGetObject(String key) {
      if (key == null) {
        throw new NullPointerException();
      }
      return lookup.get(key);
    }

    @Override
    public Enumeration<String> getKeys() {
      ResourceBundle parent = this.parent;
      return new ResourceBundleEnumeration(
          lookup.keySet(), (parent != null) ? parent.getKeys() : null);
    }

    @Override
    protected Set<String> handleKeySet() {
      return lookup.keySet();
    }
  }
}
