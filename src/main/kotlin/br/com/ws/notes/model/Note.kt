package br.com.ws.notes.model

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Generated
import lombok.NoArgsConstructor
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
@NoArgsConstructor
data class Note(@Id
           @GeneratedValue
           @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
           val id: Long =0L,
                var title: String = "",
                var description: String= "") {

}