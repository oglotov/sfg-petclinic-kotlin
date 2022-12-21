/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ua.wwind.glotov.sfgpetclinickotlin.model


import org.springframework.format.Formatter
import org.springframework.stereotype.Component
import ua.wwind.glotov.sfgpetclinickotlin.services.PetTypeService
import java.text.ParseException
import java.util.*

/**
 * Instructs Spring MVC on how to parse and print elements of type 'PetType'. Starting from Spring 3.0, Formatters have
 * come as an improvement in comparison to legacy PropertyEditors. See the following links for more details: - The
 * Spring ref doc: http://static.springsource.org/spring/docs/current/spring-framework-reference/html/validation.html#format-Formatter-SPI
 * - A nice blog entry from Gordon Dickens: http://gordondickens.com/wordpress/2010/09/30/using-spring-3-0-custom-type-converter/
 *
 * @author Mark Fisher
 * @author Juergen Hoeller
 * @author Michael Isvy
 * @author Antoine Rey
 */
@Component
class PetTypeFormatter(val petTypeService: PetTypeService) : Formatter<PetType> {

    override fun print(petType: PetType, locale: Locale): String
                = petType.name

    override fun parse(text: String, locale: Locale): PetType {
        val findPetTypes = petTypeService.findAll()
        return findPetTypes.find { it.name == text } ?:
                    throw ParseException("type not found: $text", 0)
    }

}
