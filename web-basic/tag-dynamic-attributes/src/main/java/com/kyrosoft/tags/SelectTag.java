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
public class SelectTag extends TagSupport implements DynamicAttributes{

    /** the name of the select control */
    private String name;

    /** the name of the property to be used as the displayed label */
    private String label;

    /** the name of the property to be used as the hidden value */
    private String value;

    /** the collection over which this tag should iterate */
    private Collection items;

    private Map dynamicAttributes = new HashMap();

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();

        Iterator iterator = items.iterator();
        String select = "<select name='"+name+"'";
        Iterator it = dynamicAttributes.keySet().iterator();
        while(it.hasNext()){
            String key = (String)it.next();
            String selectAttribute = " "+key+"='"+dynamicAttributes.get(key)+"' ";
            select+= selectAttribute;
        }
        select += ">";
        while(iterator.hasNext()){
            Object o = iterator.next();
            PropertyDescriptor valuePD = null;
            PropertyDescriptor labelPD = null;
            String selectValue = null;
            String selectLabel = null;

            String option = null;

            try {
                valuePD = new PropertyDescriptor(value, o.getClass());
                labelPD = new PropertyDescriptor(label, o.getClass());

                selectValue = valuePD.getReadMethod().invoke(o).toString();
                selectLabel = labelPD.getReadMethod().invoke(o).toString();
                option = "<option value ='"+selectValue+"'>"+selectLabel+"</option>";
            } catch (IntrospectionException e) {
                throw new JspException();
            } catch (InvocationTargetException e) {
                throw new JspException();
            } catch (IllegalAccessException e) {
                throw new JspException();
            }
            if(option!=null){
                select += option;
            }
        }
        select += "</select>";
        try {
            out.println(select);
        } catch (IOException e) {
            throw new JspException();
        }
        return SKIP_BODY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Collection getItems() {
        return items;
    }

    public void setItems(Collection items) {
        this.items = items;
    }

    @Override
    public void setDynamicAttribute(String uri, String name, Object value) throws JspException {
        dynamicAttributes.put(name,value);
    }
}
