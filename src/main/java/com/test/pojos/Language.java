package com.test.pojos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Language extends HashMap<String, LanguageText>
        implements Map<String, LanguageText>, Serializable {

}
