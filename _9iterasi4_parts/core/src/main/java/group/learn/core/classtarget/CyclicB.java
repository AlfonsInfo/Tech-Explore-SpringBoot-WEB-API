package group.learn.core.classtarget;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CyclicB {
    private CyclicA cyclicA;
}
