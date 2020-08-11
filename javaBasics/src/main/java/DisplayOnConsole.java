import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class DisplayOnConsole implements DisplayOn{
  @Override
  public void display (String... messageLines) {
    Optional<String[]> checkIfNotNullArgument = Optional.ofNullable(messageLines);
    if(checkIfNotNullArgument.isPresent()) {
	  Stream<String> messagesToDisplay = Arrays.stream(messageLines);

	  messagesToDisplay
		  .map(Optional::ofNullable)
		  .filter(Optional::isPresent)
		  .map(Optional::get)
		  .forEach(System.out::println);
	}else{
	  System.out.println("Nothing to display");
	}

  }
}
