package com.test.annot;
/**
   @version 1.00 2004-08-17
   @author Cay Horstmann
*/

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface ActionListenerFor
{
   String source();
}

