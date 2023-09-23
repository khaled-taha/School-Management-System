package org.classJump.utils;

public class ToStringParsing {
    public static String[] extractAttributes(String toStringOutput) {
        // Remove the class name and surrounding braces
        String content = toStringOutput.substring(toStringOutput.indexOf("{") + 1, toStringOutput.lastIndexOf("}"));

        // Split the content into attribute pairs
        String[] attributePairs = content.replaceAll("'", "").split(",");

        // Trim and store attribute values in a String array
        String[] attributes = new String[attributePairs.length];
        for (int i = 0; i < attributePairs.length; i++) {
            String[] parts = attributePairs[i].split("=");
            if (parts.length == 2) {
                attributes[i] = parts[1].trim();
            }
        }

        return attributes;
    }
}
