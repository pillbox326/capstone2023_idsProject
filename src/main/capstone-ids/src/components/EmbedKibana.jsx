import styles from "./EmbedKibana.module.css";
import PropTypes from "prop-types";

function EmbedKibana({ url }) {
  return (
    <div className={styles.embedContainer}>
      <iframe
        src={url}
        // height="600"
        // width="800"
      ></iframe>{" "}
    </div>
  );
}
EmbedKibana.propTypes = {
  url: PropTypes.string.isRequired,
};
export default EmbedKibana;
