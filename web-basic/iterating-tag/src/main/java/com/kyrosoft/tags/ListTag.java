package com.kyrosoft.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 10/29/15.
 */
public class ListTag extends TagSupport {

    /** the collection over which this tag should iterate */
    private Collection items;

    private String var;

    private Iterator iterator;

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();

        iterator = items.iterator();
        if(!items.isEmpty()){
            if(iterator.hasNext()) {
                pageContext.setAttribute(var,iterator.next());
                return EVAL_BODY_INCLUDE;
            }
        }
        return SKIP_BODY;
    }

    public int doAfterBody() throws JspException {
        if(iterator.hasNext()) {
            pageContext.setAttribute(var,iterator.next());
            return EVAL_BODY_AGAIN;
        }
        return SKIP_BODY;
    }

    public Collection getItems() {
        return items;
    }

    public void setItems(Collection items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }
}
