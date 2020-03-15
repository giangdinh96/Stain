package com.returnnotfound.stain.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Collection Utils
 */

public abstract class CollectionUtils {
  public static boolean isNull(Collection collection) {
    return collection == null;
  }

  public static boolean isEmpty(Collection collection) {
    return collection != null && collection.isEmpty();
  }

  public static boolean isNullOrEmpty(Collection collection) {
    return collection == null || collection.isEmpty();
  }

  public static boolean isNotEmpty(Collection collection) {
    return collection != null && !collection.isEmpty();
  }

  public static boolean isNull(Map map) {
    return map == null;
  }

  public static boolean isNullOrEmpty(Map map) {
    return map == null || map.isEmpty();
  }

  public static boolean isNotEmpty(Map map) {
    return map != null && !map.isEmpty();
  }

  public static <E> boolean isContains(List<E> list, E e) {
    if (isNullOrEmpty(list))
      return false;
    return list.contains(e);
  }

  public static <E> E getFirstItem(List<E> list) {
    if (isNullOrEmpty(list))
      return null;
    return list.get(0);
  }

  public static <E> E getLastItem(List<E> list) {
    if (isNullOrEmpty(list))
      return null;
    return list.get(list.size() - 1);
  }

  public static <E> boolean isFirstItem(List<E> list, E e) {
    if (isNullOrEmpty(list))
      return false;
    return list.indexOf(e) == 0;
  }

  public static <E> boolean isLastItem(List<E> list, E e) {
    if (isNullOrEmpty(list))
      return false;
    return list.indexOf(e) == list.size() - 1;
  }
}