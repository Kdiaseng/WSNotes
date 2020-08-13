package br.com.ws.notes.model


import lombok.NoArgsConstructor
import javax.persistence.Entity

@Entity
@NoArgsConstructor
data class Note(var title: String = "",
                var description: String= "") : BaseEntity() {

}