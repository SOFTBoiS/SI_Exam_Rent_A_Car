package models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document
public class Order {
    @Id
    String id;
    @Getter
    @NonNull String username;
    @Getter
    @NonNull int carId;
}
